package pl.dmagnuckibankapp.enums;

/**
 * **************************ACCOUNTS DESCRIPTION**************************
 *                         1. Checking Account
 *                         Purpose: Everyday spending and bill payments
 *                         Key features:
 *                         Debit card for easy access to funds
 *                         Unlimited transactions
 *                         No interest or low interest
 *                         May have monthly fees
 *
 *                         2. Savings Account
 *                         Purpose: Saving money and earning interest
 *                         Key features:
 *                         Higher interest rates than checking accounts
 *                         Limited number of monthly transactions
 *                         May have minimum balance requirements
 *                         No debit card or checks
 *
 *                         3. Money Market Account
 *                         Purpose: Earning higher interest while maintaining liquidity
 *                         Key features:
 *                         Higher interest rates than savings accounts
 *                         Limited check-writing privileges
 *                         May have minimum balance requirements
 *
 *                         4. Certificate of Deposit (CD)
 *                         Purpose: Investing money for a fixed term to earn higher interest
 *                         Key features:
 *                         Fixed interest rate for the term of the CD
 *                         Early withdrawal penalties
 *                         No access to funds until maturity date
 */
public enum AccountType {
    CHECKING_ACCOUNT,
    SAVINGS_ACCOUNT,
    MONEY_MARKET_ACCOUNT,
    CERTIFICATE_OF_DEPOSIT;


}
