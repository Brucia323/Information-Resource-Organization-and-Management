package zcy.socialpension.services;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zcy.socialpension.models.AgencyPerson;
import zcy.socialpension.models.CremationData;
import zcy.socialpension.models.EmployeePerson;
import zcy.socialpension.models.TreatmentPaymentDetail;
import zcy.socialpension.repositoris.AgencyPersonRepository;
import zcy.socialpension.repositoris.CremationDataRepository;
import zcy.socialpension.repositoris.EmployeePersonRepository;
import zcy.socialpension.repositoris.TreatmentPaymentDetailRepository;

import javax.annotation.Resource;
import java.util.*;

/**
 * @see zcy.socialpension.services.ImportToNeo4j
 */
@Slf4j
@Service
public class ImportToNeo4jImpl implements ImportToNeo4j {
    @Resource
    private AgencyPersonRepository agencyPersonRepository;
    @Resource
    private EmployeePersonRepository employeePersonRepository;
    @Resource
    private TreatmentPaymentDetailRepository treatmentPaymentDetailRepository;
    @Resource
    private CremationDataRepository cremationDataRepository;

    @Override
    public void importAgencyPerson(String filename) {
        CsvReader csvReader = CsvUtil.getReader();
        List<AgencyPerson> agencyPersonList = csvReader.read(ResourceUtil.getUtf8Reader(filename), AgencyPerson.class);
        if (agencyPersonList.isEmpty()) {
            log.warn("找不到文件或文件为空");
            return;
        }
        Set<AgencyPerson> agencyPersonSet = new HashSet<>(agencyPersonList);
        agencyPersonList = new ArrayList<>();
        for (AgencyPerson agencyPerson : agencyPersonSet) {
            agencyPerson.setTreatmentPaymentDetailSet(treatmentPaymentDetailRepository.findAllByPersonId(agencyPerson.getId()));
            agencyPerson.setCremationData(cremationDataRepository.findByIdNumber(agencyPerson.getIdNumber()));
            agencyPersonList.add(agencyPerson);
        }
        agencyPersonRepository.saveAll(agencyPersonList);
    }

    @Override
    public void importEmployeePerson(String filename) {
        CsvReader csvReader = CsvUtil.getReader();
        List<EmployeePerson> employeePersonList = csvReader.read(ResourceUtil.getUtf8Reader(filename), EmployeePerson.class);
        if (employeePersonList.isEmpty()) {
            log.warn("找不到文件或文件为空");
            return;
        }
        Set<EmployeePerson> employeePersonSet = new HashSet<>(employeePersonList);
        employeePersonList = new ArrayList<>();
        for (EmployeePerson employeePerson : employeePersonSet) {
            employeePerson.setCremationData(cremationDataRepository.findByIdNumber(employeePerson.getIdNumber()));
            employeePersonList.add(employeePerson);
        }
        employeePersonRepository.saveAll(employeePersonSet);
    }

    @Override
    public void importTreatmentPaymentDetail(String filename) {
        CsvReader csvReader = CsvUtil.getReader();
        List<TreatmentPaymentDetail> treatmentPaymentDetailList = csvReader.read(ResourceUtil.getUtf8Reader(filename), TreatmentPaymentDetail.class);
        if (treatmentPaymentDetailList.isEmpty()) {
            log.warn("找不到文件或文件为空");
            return;
        }
        Set<TreatmentPaymentDetail> treatmentPaymentDetailSet = new HashSet<>(treatmentPaymentDetailList);
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMM");
//        treatmentPaymentDetailList=new ArrayList<>();
//        for (TreatmentPaymentDetail treatmentPaymentDetail : treatmentPaymentDetailSet) {
//            treatmentPaymentDetail.setTreatmentDate(String.valueOf(LocalDate.parse(treatmentPaymentDetail.getTreatmentDate(), dateTimeFormatter)));
//            treatmentPaymentDetailList.add(treatmentPaymentDetail);
//        }
        treatmentPaymentDetailRepository.saveAll(treatmentPaymentDetailSet);
    }

    @Override
    public void importCremationData(String filename) {
        CsvReader csvReader = CsvUtil.getReader();
        List<CremationData> cremationDataList = csvReader.read(ResourceUtil.getUtf8Reader(filename), CremationData.class);
        if (cremationDataList.isEmpty()) {
            log.warn("找不到文件或文件为空");
            return;
        }
        Map<String, CremationData> cremationDataMap = new HashMap<>();
        for (CremationData cremationData : cremationDataList) {
            if (!cremationDataMap.containsKey(cremationData.getIdNumber())) {
                cremationDataMap.put(cremationData.getIdNumber(), cremationData);
            }
        }
        cremationDataList = new ArrayList<>(cremationDataMap.values());
        cremationDataRepository.saveAll(cremationDataList);
    }
}
