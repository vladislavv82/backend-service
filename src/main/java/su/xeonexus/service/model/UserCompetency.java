package su.xeonexus.service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "competencies")
public class UserCompetency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uid;

    private Boolean isCompetentInPaymentIssue;
    private Boolean isCompetentInCreateAccount;
    private Boolean isCompetentInContactCustomerService;
    private Boolean isCompetentInGetInvoice;
    private Boolean isCompetentInTrackOrder;
    private Boolean isCompetentInGetRefund;
    private Boolean isCompetentInContactHumanAgent;
    private Boolean isCompetentInRecoverPassword;
    private Boolean isCompetentInChangeOrder;
    private Boolean isCompetentInDeleteAccount;
    private Boolean isCompetentInComplaint;
    private Boolean isCompetentInCheckInvoices;
    private Boolean isCompetentInReview;
    private Boolean isCompetentInCheckRefundPolicy;
    private Boolean isCompetentInDeliveryOptions;
    private Boolean isCompetentInCheckCancellationFee;
    private Boolean isCompetentInTrackRefund;
    private Boolean isCompetentInCheckPaymentMethods;
    private Boolean isCompetentInSwitchAccount;
    private Boolean isCompetentInNewsletterSubscription;
    private Boolean isCompetentInDeliveryPeriod;
    private Boolean isCompetentInEditAccount;
    private Boolean isCompetentInRegistrationProblems;
    private Boolean isCompetentInChangeShippingAddress;
    private Boolean isCompetentInSetUpShippingAddress;
    private Boolean isCompetentInPlaceOrder;
    private Boolean isCompetentInCancelOrder;
    private Boolean isCompetentInCheckInvoice;

}