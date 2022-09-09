package zcy.socialpension.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zcy.socialpension.models.AgencyPerson;
import zcy.socialpension.models.TreatmentPaymentDetail;
import zcy.socialpension.repositoris.AgencyPersonRepository;
import zcy.socialpension.repositoris.EmployeePersonRepository;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see zcy.socialpension.services.GetPersonList
 */
@Service
@Slf4j
public class GetPersonListImpl implements GetPersonList {
    @Resource
    private AgencyPersonRepository agencyPersonRepository;
    @Resource
    private EmployeePersonRepository employeePersonRepository;

    @Override
    public Map<String, Double> getReceiveAfterDeath() {
        Map<String, Double> map = new HashMap<>();
        List<AgencyPerson> agencyPersonList = agencyPersonRepository.findAll();
        for (AgencyPerson agencyPerson : agencyPersonList) {
            LocalDate deathDate = agencyPerson.getDeathDate();
            List<TreatmentPaymentDetail> treatmentPaymentDetailList = new ArrayList<>(agencyPerson.getTreatmentPaymentDetailSet());
            double count = 0.0;
            for (TreatmentPaymentDetail treatmentPaymentDetail : treatmentPaymentDetailList) {
                if (Period.between(LocalDate.parse(treatmentPaymentDetail.getTreatmentDate()), deathDate).getMonths() < 0) {
                    try {
                        count += Double.parseDouble(treatmentPaymentDetail.getTreatmentAmount());
                    } catch (Exception e) {
                        log.warn("empty String: {}", treatmentPaymentDetail);
                    }
                }
            }
            if (count != 0.0) {
                map.put(agencyPerson.getName(), count);
            }
        }
        return map;
    }
}
