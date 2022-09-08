package zcy.socialpension.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import zcy.socialpension.models.Person;
import zcy.socialpension.repositoris.AgencyPersonRepository;
import zcy.socialpension.repositoris.EmployeePersonRepository;

import javax.annotation.Resource;
import java.util.HashMap;
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
    public Map<Person, Double> getReceiveAfterDeath() {
        Map<Person, Double> personDoubleMap = new HashMap<>();
//        List<AgencyPerson> agencyPersonList = agencyPersonRepository.findAll();
//        for (AgencyPerson agencyPerson : agencyPersonList) {
//            LocalDate deathDate = agencyPerson.getDeathDate();
//            List<TreatmentPaymentDetail> treatmentPaymentDetailList = new ArrayList<>(agencyPerson.getTreatmentPaymentDetailSet());
//            treatmentPaymentDetailList.sort((o1, o2) -> Period.between(o1.getTreatmentDate(), o2.getTreatmentDate()).getDays());
//            double count = 0.0;
//            for (TreatmentPaymentDetail treatmentPaymentDetail : treatmentPaymentDetailList) {
//                if (Period.between(treatmentPaymentDetail.getTreatmentDate(), deathDate).getDays() >= 0) {
//                    break;
//                }
//                count += Double.parseDouble(treatmentPaymentDetail.getTreatmentAmount());
//            }
//            if (count != 0) {
//                personDoubleMap.put(agencyPerson, count);
//            }
//        }
        return personDoubleMap;
    }
}
