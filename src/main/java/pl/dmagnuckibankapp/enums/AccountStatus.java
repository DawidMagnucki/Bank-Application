package pl.dmagnuckibankapp.enums;

public enum AccountStatus {
    ACTIVE,
    BLOCKED,
    FROZEN,
    INACTIVE,
    CLOSED,
    UNDER_REVIEW,
    RESTRICTED;


    /*
    **********************************************************************

    Active (Active): The account is fully functional and the user can use banking services normally.

    Blocked (Blocked): Access to the account has been restricted, usually due to suspected abnormal activity or security.

    Frozen (Frozen): All transactions on the account are temporarily halted. This may be due to suspected fraud or other
    irregularity.

    Inactive (Inactive): The account is open, but there has been no activity for an extended period of time. Some
    services may be restricted until your identity is reconfirmed.

    Closed (Closed): The user has decided to stop using the account, and the account has been closed.

    Verification Pending (Under Review): The account is currently being reviewed or verified due to certain actions
    or events.

    Restricted (Restricted): Access to certain features of the account may be restricted due to various factors,
    such as security or transaction issues.

    **********************************************************************
     */
}
