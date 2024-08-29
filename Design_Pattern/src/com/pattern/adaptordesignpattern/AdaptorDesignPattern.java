package com.pattern.adaptordesignpattern;

public class AdaptorDesignPattern {

	public static void main(String[] args) {

		BillDesk b = new Insurance();
		b.setPaymentType("UPI");
		b.setDetails("8745157458@okaxis.com");
	
		PayTm payTm = PaymentAdaptorForPayTm.ConvertBillDeskToPayTm(b);
	
		System.out.println(payTm);
	}

}

interface BillDesk {

	void setPaymentType(String paymentType);

	String getPaymentType();

	void setDetails(String Data);

	String getDetails();

}

interface PayTm {

	void setTypeOfPayment(String PaymentType);

	String getTypeOfPayment();

	void setDetails(String data);

	String getDetails();

}

class PaymentAdaptorForPayTm {

	static PayTm payTm ;

	public PaymentAdaptorForPayTm(PayTm payTm) {
		this.payTm = payTm;
	}
	
	static PayTm ConvertBillDeskToPayTm(BillDesk billDesk) {
		
		payTm.setTypeOfPayment(billDesk.getPaymentType());
		payTm.setDetails(billDesk.getDetails());

		return payTm;
	}

}

class Insurance implements BillDesk {

	String PaymetType ;
	String Data ;

	@Override
	public void setPaymentType(String paymentType) {

		this.PaymetType = paymentType;
	}

	@Override
	public String getPaymentType() {

		return PaymetType;
	}

	@Override
	public void setDetails(String data) {

		this.Data = data;
	}

	@Override
	public String getDetails() {

		return Data;
	}

}
