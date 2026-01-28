package Service;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContractService {

    private final OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, int months){

        double liquidValuePerMonth = contract.getTotalValue()/months;

        for (int i = 1; i <= months; i++){
            LocalDate dueDate = contract.getData().plus(i, ChronoUnit.MONTHS);
            Double amount = paymentService.interest(liquidValuePerMonth, i);

            contract.addInstallment(new Installment(amount, dueDate));
        }

    }
}
