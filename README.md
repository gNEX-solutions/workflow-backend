# workflow-backend
backend for workflow management system



**Allowed Inputs**

1. User Designations
    - HOD
    - SENIOR_TREASURER
    - JUNIOR_TREASURER
    - PRESIDENT
    - SECRETARY
    - COORDINATOR
  
2. Event Inspectors Status
    - APPROVED
    - REJECTED
    - PENDING
  
3. Event Status
    - DONE
    - PUBLISHED
    - PENDING
    - CONFIRMED
    - REJECTED
 
4. User Status
    - ACTIVE
    - INACTIVE
    

**DataInitializer class**  will create 3 **_ACTIVE_ hod,senior treasurer and a president**. Therefore __REFRAIN__ from creating more _active_ users with the above mentioned 3 designations.

The system will assign the 3 active hod, senior treasurer and president for new events automatically. 

Therefore if you want to change the active users with above mentioned designations please edit the datainitializer or disable the data initializer **(you can comment the user creation code)** and go ahead with user creation with http requests.

>Happy Coding
