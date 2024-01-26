package pl.dmagnuckibankapp.enums;

public enum Permissions {
    FULL,LIMITED,RESTRICTED

    /* ************************************ DESCRIPTION ************************************
     Full Access:
     - Can perform all operations, including reading, updating, creating, and deleting.
     - Has complete control and authority over the resources.

     Limited Access (or Partial Access):
     - Can perform certain operations, typically a subset of the full access.
     - Specific permissions may vary but usually includes reading and updating,
       excluding some critical operations like deletion or creation.

     Restricted Access:
     - Has the most limited set of permissions.
     - Usually limited to only reading, without the ability to modify or delete resources.
     - Provides the least level of control and is often used for scenarios where users need
       information access but not the ability to make changes.
     *************************************************************************************** */

}
