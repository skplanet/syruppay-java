/*
 * Syrup Pay Token Library
 *
 * Copyright (C) 2015 SK PLANET. ALL Rights Reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the SK PLANET., Bundang-gu, 264,
 * Pangyo-ro The Planet SK planet co., Ltd., Seongnam-si, Gyeonggi-do, Korea
 * or see https://www.syruppay.co.kr/
 */

package com.skplanet.syruppay.token.claims;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.skplanet.syruppay.token.Builder;

import java.io.Serializable;
import java.util.*;

/**
 * 결제를 위한 거래 인증 정보를 Claim 을 설정한다.
 *
 * @author 임형태
 * @since 1.0
 */
public final class PayClaim<H extends Builder<H>> extends AbstractTokenClaim<PayClaim<H>, H> {
    private static final Set<String> ISO_LANGUAGES = new HashSet<String>(Arrays.asList(Locale.getISOLanguages()));
    private static final Set<String> ISO_COUNTRIES = new HashSet<String>(Arrays.asList(Locale.getISOCountries()));

    private String mctTransAuthId;
    private String mctDefinedValue;
    private PaymentType paymentType = PaymentType.PAY;
    private AuthenticatableMeans authenticatableMeans;
    private PaymentInformationBySeller paymentInfo = new PaymentInformationBySeller();
    private PaymentRestriction paymentRestrictions = new PaymentRestriction();
    private CashReceiptDisplay cashReceiptDisplay;

    public PayClaim<H> forAuthenticating(final AuthenticatableMeans authenticatableMeans) {
        this.paymentType = PaymentType.AUTH_MEANS;
        this.authenticatableMeans = authenticatableMeans;
        return this;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public AuthenticatableMeans getAuthenticatableMeans() {
        return authenticatableMeans;
    }

    public enum CashReceiptDisplay {
        YES, NO, DELEGATE_ADMIN
    }

    public CashReceiptDisplay getCashReceiptDisplay() {
        return cashReceiptDisplay;
    }

    public PayClaim<H> withCashReceiptDisplay(final CashReceiptDisplay cashReceiptDisplay) {
        this.cashReceiptDisplay = cashReceiptDisplay;
        return this;
    }

    public static boolean isValidCountryAlpha2Code(final String code) {
        return ISO_COUNTRIES.contains(code.contains(":") ? code.substring(code.indexOf(":") + 1).toUpperCase() : code.toUpperCase());
    }

    public static boolean isValidLanuageCode(final String code) {
        return ISO_LANGUAGES.contains(code);
    }

    @Deprecated
    public String getMctTransAuthId() {
        return mctTransAuthId;
    }

    @JsonIgnore
    public String getMerchantTransationAuthentcatedId() {
        return mctTransAuthId;
    }

    public PaymentInformationBySeller getPaymentInfo() {
        return paymentInfo;
    }

    public PaymentRestriction getPaymentRestrictions() {
        return paymentRestrictions;
    }

    public PayClaim<H> withOrderIdOfMerchant(final String orderId) {
        mctTransAuthId = orderId;
        return this;
    }

    public PayClaim<H> withMerchantDefinedValue(final String merchantDefinedValue) {
        this.mctDefinedValue = merchantDefinedValue;
        return this;
    }


    @Deprecated
    public String getMctDefinedValue() {
        return mctDefinedValue;
    }

    @JsonIgnore
    public String getMerchanttDefinedValue() {
        return mctDefinedValue;
    }

    public PayClaim<H> withProductTitle(final String productTitle) {
        paymentInfo.productTitle = productTitle;
        return this;
    }

    public PayClaim<H> withProductUrls(final List<String> productUrls) {
        for (String productDetail : productUrls) {
            if (!(productDetail.startsWith("http") || productDetail.startsWith("https"))) {
                throw new IllegalArgumentException("product details should be contained http or https urls. check your input!");
            }
        }
        paymentInfo.productUrls.addAll(productUrls);
        return this;
    }

    public PayClaim<H> withProductUrls(final String... url) {
        return withProductUrls(Arrays.asList(url));
    }

    public PayClaim<H> withBankInfoList(final List<Bank> bankInfoList) {
        paymentInfo.bankInfoList.addAll(bankInfoList);
        return this;
    }

    public PayClaim<H> withBankInfoList(final Bank... bank) {
        return withBankInfoList(Arrays.asList(bank));
    }

    public PayClaim<H> withLanguageForDisplay(final Language l) {
        paymentInfo.lang = l.toString();
        return this;
    }

    public PayClaim<H> withCurrency(final Currency c) {
        paymentInfo.currencyCode = c.toString();
        return this;
    }

    public PayClaim<H> withShippingAddress(final ShippingAddress shippingAddress) {
        paymentInfo.shippingAddress = shippingAddress.mapToStringForFds();
        return this;
    }

    public PayClaim<H> withShippingAddress(final String shippingAddress) {
        paymentInfo.shippingAddress = shippingAddress;
        return this;
    }

    public PayClaim<H> withAmount(final int paymentAmount) {
        if (paymentAmount <= 0) {
            throw new IllegalArgumentException("Cannot be smaller than 0. Check yours input value : " + paymentAmount);
        }
        paymentInfo.paymentAmt = paymentAmount;
        return this;
    }

    public PayClaim<H> withDeliveryPhoneNumber(final String deliveryPhoneNumber) {
        paymentInfo.deliveryPhoneNumber = deliveryPhoneNumber;
        return this;
    }

    public PayClaim<H> withDeliveryName(final String deliveryName) {
        paymentInfo.deliveryName = deliveryName;
        return this;
    }

    public PayClaim<H> withDeliveryType(final DeliveryType deliveryType) {
        paymentInfo.deliveryType = deliveryType;
        return this;
    }

    public PayClaim<H> withBeAbleToExchangeToCash(final boolean exchangeable) {
        paymentInfo.isExchangeable = exchangeable;
        return this;
    }

    public PayClaim<H> withInstallmentPerCardInformation(final List<CardInstallmentInformation> cards) {
        paymentInfo.cardInfoList.addAll(cards);
        return this;
    }

    public PayClaim<H> withInstallmentPerCardInformation(final CardInstallmentInformation... card) {
        paymentInfo.cardInfoList.addAll(Arrays.asList(card));
        return this;
    }

    public PayClaim<H> withRestrictionOf(final PayableLocaleRule r) {
        paymentRestrictions.cardIssuerRegion = r.toCode();
        return this;
    }

    public PayClaim<H> withRestrictionOf(final SpecifiedPaymentMethods sp) {
        paymentRestrictions.specifiedPaymentMethods = sp;
        return this;
    }


    @Deprecated
    public PayClaim<H> withPayableRuleWithCard(final PayableLocaleRule r) {
        paymentRestrictions.cardIssuerRegion = r.toCode();
        return this;
    }

    public PayClaim<H> withRestrictionOf(final MatchedUser matchedUser) {
        paymentRestrictions.matchedUser = matchedUser;
        return this;
    }

    @Deprecated
    public PayClaim<H> withMatchedUser(final MatchedUser matchedUser) {
        paymentRestrictions.matchedUser = matchedUser;
        return this;
    }

    public PayClaim<H> withRestrictionPaymentTypeOf(final String paymentType) {
        paymentRestrictions.paymentType = paymentType;
        return this;
    }


    public String claimName() {
        return "transactionInfo";
    }

    public void validRequired() throws Exception {
        if (this.mctTransAuthId == null || this.mctTransAuthId.length() == 0
                || this.paymentInfo.productTitle == null || this.paymentInfo.productTitle.length() == 0
                || this.paymentInfo.lang == null || this.paymentInfo.lang.length() == 0
                || this.paymentInfo.currencyCode == null || this.paymentInfo.currencyCode.length() == 0
                || this.paymentInfo.paymentAmt <= 0) {
            throw new IllegalArgumentException("some of required fields is null(or empty) or wrong. " +
                    "you should set orderIdOfMerchant : " + mctTransAuthId
                    + ",  productTitle : " + paymentInfo.productTitle
                    + ",  languageForDisplay : " + paymentInfo.lang
                    + ",  currency : " + paymentInfo.currencyCode
                    + ",  amount : " + paymentInfo.paymentAmt
            );
        }

        if (mctTransAuthId.length() > 40) {
            throw new IllegalArgumentException("order id of merchant couldn't be longer than 40. but yours is " + mctTransAuthId.length());
        }
        if (mctDefinedValue != null && mctDefinedValue.length() > 1024) {
            throw new IllegalArgumentException("merchant define value's length couldn't be bigger than 1024. but yours is " + mctDefinedValue.length());
        }
    }


    public enum Language {
        KO, EN
    }

    public enum Currency {
        KRW, USD
    }

    public enum PayableLocaleRule {
        ONLY_ALLOWED_KOR("ALLOWED:KOR"), ONLY_NOT_ALLOWED_KOR("NOT_ALLOWED:KOR"), ONLY_ALLOWED_USA("ALLOWED:USA"), ONLY_NOT_ALLOWED_USA("NOT_ALLOWED:USA");

        String code;

        PayableLocaleRule(String code) {
            this.code = code;
        }

        public String toCode() {
            return code;
        }
    }

    public enum DeliveryRestriction {
        NOT_FAR_AWAY, FAR_AWAY, FAR_FAR_AWAY
    }

    public enum DeliveryType {
        PREPAID, FREE, DIY, QUICK, PAYMENT_ON_DELIVERY
    }

    public static final class ShippingAddress implements Serializable {
        private static final long serialVersionUID = 5453957807241639495L;
        private String id;
        private String userActionCode;
        private String name;
        private String countryCode;
        private String zipCode;
        private String mainAddress;
        private String detailAddress;
        private String city;
        private String state;
        private String recipientName;
        private String recipientPhoneNumber;
        private DeliveryRestriction deliveryRestriction;
        private Integer defaultDeliveryCost;
        private Integer additionalDeliveryCost;
        private Integer orderApplied;

        public ShippingAddress() {
        }

        public ShippingAddress(final String zipCode, final String mainAddress, final String detailAddress, final String city, final String state, final String countryCode) {
            this.zipCode = zipCode;
            this.mainAddress = mainAddress;
            this.detailAddress = detailAddress;
            this.city = city;
            this.state = state;
            this.countryCode = setCountryCode(countryCode).getCountryCode();
        }

        public String getUserActionCode() {
            return userActionCode;
        }

        public ShippingAddress setUserActionCode(final String userActionCode) {
            this.userActionCode = userActionCode;
            return this;
        }

        public String getId() {
            return id;
        }

        public ShippingAddress setId(final String id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public ShippingAddress setName(final String name) {
            this.name = name;
            return this;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public ShippingAddress setCountryCode(final String countryCode) {
            if (!isValidCountryAlpha2Code(countryCode)) {
                throw new IllegalArgumentException("countryCode should meet the specifications of ISO-3166 Alpha2(as KR, US) except prefix like a2. yours : " + countryCode);
            }
            this.countryCode = countryCode.toLowerCase();
            return this;
        }

        public String getZipCode() {
            return zipCode;
        }

        public ShippingAddress setZipCode(final String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public String getMainAddress() {
            return mainAddress;
        }

        public ShippingAddress setMainAddress(final String mainAddress) {
            this.mainAddress = mainAddress;
            return this;
        }

        public String getDetailAddress() {
            return detailAddress;
        }

        public ShippingAddress setDetailAddress(final String detailAddress) {
            this.detailAddress = detailAddress;
            return this;
        }

        public String getCity() {
            return city;
        }

        public ShippingAddress setCity(final String city) {
            this.city = city;
            return this;
        }

        public String getState() {
            return state;
        }

        public ShippingAddress setState(final String state) {
            this.state = state;
            return this;
        }

        public String getRecipientName() {
            return recipientName;
        }

        public ShippingAddress setRecipientName(final String recipientName) {
            this.recipientName = recipientName;
            return this;
        }

        public String getRecipientPhoneNumber() {
            return recipientPhoneNumber;
        }

        public ShippingAddress setRecipientPhoneNumber(final String recipientPhoneNumber) {
            if (recipientPhoneNumber != null && !recipientPhoneNumber.matches("\\d+")) {
                throw new IllegalArgumentException("phone number should be contained numbers. remove characters as '-'. yours : " + recipientPhoneNumber);
            }
            this.recipientPhoneNumber = recipientPhoneNumber;
            return this;
        }

        public DeliveryRestriction getDeliveryRestriction() {
            return deliveryRestriction;
        }

        public ShippingAddress setDeliveryRestriction(final DeliveryRestriction deliveryRestriction) {
            this.deliveryRestriction = deliveryRestriction;
            return this;
        }

        public Integer getDefaultDeliveryCost() {
            return defaultDeliveryCost;
        }

        public ShippingAddress setDefaultDeliveryCost(final Integer defaultDeliveryCost) {
            this.defaultDeliveryCost = defaultDeliveryCost;
            return this;
        }

        public Integer getAdditionalDeliveryCost() {
            return additionalDeliveryCost;
        }

        public ShippingAddress setAdditionalDeliveryCost(final Integer additionalDeliveryCost) {
            this.additionalDeliveryCost = additionalDeliveryCost;
            return this;
        }

        public int getOrderApplied() {
            return orderApplied;
        }

        public ShippingAddress setOrderApplied(final Integer orderApplied) {
            this.orderApplied = orderApplied;
            return this;
        }

        public String mapToStringForFds() {
            return countryCode + "|" + zipCode + "|" + mainAddress + "|" + detailAddress + "|" + city + "|" + state + "|";
        }

        public void validRequiredToCheckout() {
            if (id == null || name == null || countryCode == null || zipCode == null || mainAddress == null || detailAddress == null || recipientName == null || recipientPhoneNumber == null) {
                throw new IllegalArgumentException("ShippingAddress object to checkout couldn't be with null fields. id : " + id + ", name : " + name + ", countryCode : " + countryCode + ", zipCode : " + zipCode + ", mainAddress : " + mainAddress + ", detailAddress : " + detailAddress + ", recipientName : " + recipientName + ", recipientPhoneNumber : " + recipientPhoneNumber);
            }

            if (!isValidCountryAlpha2Code(countryCode)) {
                throw new IllegalArgumentException("countryCode should meet the specifications of ISO-3166 Alpha2(as KR, US) except prefix like a2. yours : " + countryCode);
            }

            if (defaultDeliveryCost < 0) {
                throw new IllegalArgumentException("defaultDeliveryCost field should be bigger than 0. yours : " + defaultDeliveryCost);
            }
        }
    }

    public static final class CardInstallmentInformation implements Serializable {
        private static final long serialVersionUID = 3062753174786502628L;
        private String cardCode;
        private String monthlyInstallmentInfo;

        public CardInstallmentInformation() {
        }

        public CardInstallmentInformation(final String cardCode, final String monthlyInstallmentInfo) {
            this.cardCode = cardCode;
            this.monthlyInstallmentInfo = monthlyInstallmentInfo;
        }

        public String getCardCode() {
            return cardCode;
        }

        public String getMonthlyInstallmentInfo() {
            return monthlyInstallmentInfo;
        }
    }

    public static final class PaymentInformationBySeller implements Serializable {
        private static final long serialVersionUID = -3493693117216167705L;
        private List<CardInstallmentInformation> cardInfoList = new ArrayList<CardInstallmentInformation>();
        private String productTitle;
        private List<String> productUrls = new ArrayList<String>();
        private String lang = "KO";
        private String currencyCode = "KRW";
        private int paymentAmt;
        private String shippingAddress;
        private String deliveryPhoneNumber;
        private String deliveryName;
        private DeliveryType deliveryType;
        private boolean isExchangeable;
        private List<Bank> bankInfoList = new ArrayList<Bank>();

        public String getProductTitle() {
            return productTitle;
        }

        public List<String> getProductUrls() {
            return Collections.unmodifiableList(productUrls);
        }

        public String getLang() {
            return lang;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public int getPaymentAmt() {
            return paymentAmt;
        }

        public String getShippingAddress() {
            return shippingAddress;
        }

        public String getDeliveryPhoneNumber() {
            return deliveryPhoneNumber;
        }

        public String getDeliveryName() {
            return deliveryName;
        }

        @JsonProperty("isExchangeable")
        public boolean isExchangeable() {
            return isExchangeable;
        }

        @JsonProperty("isExchangeable")
        public void setIsExchangeable(boolean isExchangeable) {
            this.isExchangeable = isExchangeable;
        }

        public List<CardInstallmentInformation> getCardInfoList() {
            return Collections.unmodifiableList(cardInfoList);
        }

        public DeliveryType getDeliveryType() {
            return deliveryType;
        }

        public List<Bank> getBankInfoList() {
            return bankInfoList;
        }

        @Deprecated
        @JsonProperty("productDetails")
        public void setProductDetails(final List<String> productDetails) {
            this.productUrls = productDetails;
        }
    }

    public static final class PaymentRestriction implements Serializable {
        private static final long serialVersionUID = 3528805314551672041L;
        private String cardIssuerRegion = "ALLOWED:KOR";
        private MatchedUser matchedUser;
        private String paymentType;
        private SpecifiedPaymentMethods specifiedPaymentMethods;

        public String getCardIssuerRegion() {
            return cardIssuerRegion;
        }

        public MatchedUser getMatchedUser() {
            return matchedUser;
        }

        public String getPaymentType() {
            return paymentType;
        }

        public SpecifiedPaymentMethods getSpecifiedPaymentMethods() {
            return specifiedPaymentMethods;
        }

        @JsonIgnore
        public PayableLocaleRule getPayableLocaleRule() {
            for (PayableLocaleRule r : PayableLocaleRule.values()) {
                if (r.toCode().equals(cardIssuerRegion.toUpperCase())) {
                    return r;
                }
            }
            throw new IllegalArgumentException("cardIssuerRegion of this object is not matched with PaymentRestriction enumeration. check this : " + this.cardIssuerRegion);
        }

    }

    public enum MatchedUser implements Serializable {
        CI_MATCHED_ONLY
    }

    public static class Bank implements Serializable {
        private String bankCode;

        public String getBankCode() {
            return bankCode;
        }

        public Bank setBankCode(String bankCode) {
            this.bankCode = bankCode;
            return this;
        }
    }

    public enum AuthenticatableMeans {
        CREDIT_CARD, BANK_TRANSFER, PHONE_BILL
    }

    public enum PaymentType {
        PAY, CHECKOUT, SUBSCRIPTION, AUTH_MEANS
    }

    public static class SpecifiedPaymentMethods implements Serializable {
        private String paymentMethodId;

        public SpecifiedPaymentMethods() {
        }

        public SpecifiedPaymentMethods(String paymentMethodId) {
            this.paymentMethodId = paymentMethodId;
        }

        public String getPaymentMethodId() {
            return paymentMethodId;
        }

        public void setPaymentMethodId(String paymentMethodId) {
            this.paymentMethodId = paymentMethodId;
        }
    }
}
