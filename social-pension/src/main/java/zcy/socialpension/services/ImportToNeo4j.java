package zcy.socialpension.services;

/**
 * @author 周晨阳
 * @version 1.0
 */
public interface ImportToNeo4j {
    void importAgencyPerson(String filename);

    void importEmployeePerson(String filename);

    void importTreatmentPaymentDetail(String filename);

    void importCremationData(String filename);
}
