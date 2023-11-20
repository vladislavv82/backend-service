package su.xeonexus.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import su.xeonexus.service.model.UserCompetency;
import su.xeonexus.service.repository.UserCompetencyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserCompetencyService {

    @Autowired
    private UserCompetencyRepository repository;

    public UserCompetency saveUserCompetency(UserCompetency userCompetency) {
        return repository.save(userCompetency);
    }
    public List<UserCompetency> getAllUserCompetencies() {
        return repository.findAll();
    }
    public UserCompetency getUserCompetencyByUid(String uid) {
        return repository.findByUid(uid).orElse(null);
    }

    public UserCompetency saveOrUpdateUserCompetency(UserCompetency userCompetency) {
        Optional<UserCompetency> existingCompetency = repository.findByUid(userCompetency.getUid());

        if (existingCompetency.isPresent()) {
            // Обновляем существующую запись
            UserCompetency updatedCompetency = existingCompetency.get();

            // Обновляем поля
            updatedCompetency.setIsCompetentInPaymentIssue(userCompetency.getIsCompetentInPaymentIssue());
            updatedCompetency.setIsCompetentInCreateAccount(userCompetency.getIsCompetentInCreateAccount());
            updatedCompetency.setIsCompetentInContactCustomerService(userCompetency.getIsCompetentInContactCustomerService());
            updatedCompetency.setIsCompetentInGetInvoice(userCompetency.getIsCompetentInGetInvoice());
            updatedCompetency.setIsCompetentInTrackOrder(userCompetency.getIsCompetentInTrackOrder());
            updatedCompetency.setIsCompetentInGetRefund(userCompetency.getIsCompetentInGetRefund());
            updatedCompetency.setIsCompetentInContactHumanAgent(userCompetency.getIsCompetentInContactHumanAgent());
            updatedCompetency.setIsCompetentInRecoverPassword(userCompetency.getIsCompetentInRecoverPassword());
            updatedCompetency.setIsCompetentInChangeOrder(userCompetency.getIsCompetentInChangeOrder());
            updatedCompetency.setIsCompetentInDeleteAccount(userCompetency.getIsCompetentInDeleteAccount());
            updatedCompetency.setIsCompetentInComplaint(userCompetency.getIsCompetentInComplaint());
            updatedCompetency.setIsCompetentInCheckInvoices(userCompetency.getIsCompetentInCheckInvoices());
            updatedCompetency.setIsCompetentInReview(userCompetency.getIsCompetentInReview());
            updatedCompetency.setIsCompetentInCheckRefundPolicy(userCompetency.getIsCompetentInCheckRefundPolicy());
            updatedCompetency.setIsCompetentInDeliveryOptions(userCompetency.getIsCompetentInDeliveryOptions());
            updatedCompetency.setIsCompetentInCheckCancellationFee(userCompetency.getIsCompetentInCheckCancellationFee());
            updatedCompetency.setIsCompetentInTrackRefund(userCompetency.getIsCompetentInTrackRefund());
            updatedCompetency.setIsCompetentInCheckPaymentMethods(userCompetency.getIsCompetentInCheckPaymentMethods());
            updatedCompetency.setIsCompetentInSwitchAccount(userCompetency.getIsCompetentInSwitchAccount());
            updatedCompetency.setIsCompetentInNewsletterSubscription(userCompetency.getIsCompetentInNewsletterSubscription());
            updatedCompetency.setIsCompetentInDeliveryPeriod(userCompetency.getIsCompetentInDeliveryPeriod());
            updatedCompetency.setIsCompetentInEditAccount(userCompetency.getIsCompetentInEditAccount());
            updatedCompetency.setIsCompetentInRegistrationProblems(userCompetency.getIsCompetentInRegistrationProblems());
            updatedCompetency.setIsCompetentInChangeShippingAddress(userCompetency.getIsCompetentInChangeShippingAddress());
            updatedCompetency.setIsCompetentInSetUpShippingAddress(userCompetency.getIsCompetentInSetUpShippingAddress());
            updatedCompetency.setIsCompetentInPlaceOrder(userCompetency.getIsCompetentInPlaceOrder());
            updatedCompetency.setIsCompetentInCancelOrder(userCompetency.getIsCompetentInCancelOrder());
            updatedCompetency.setIsCompetentInCheckInvoice(userCompetency.getIsCompetentInCheckInvoice());

            return repository.save(updatedCompetency);
        } else {
            // Сохраняем новую запись
            return repository.save(userCompetency);
        }
    }
}