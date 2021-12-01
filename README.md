## Collection

Domain contains data about collection process for `Credit`. \
When `Credit` goes to `EXPIRED` status then `Collector` starts own work to convince `Borrower` to make payments.

`Collector` interacts with `Borrower` by telephone calls or visit borrower's home on address provided by `Borrower`.

Data about `Collector` work contains in `CollectorCredit` entry. \
`CollectorCredit` cannot exist without `Credit`. \
One `CollectorCredit` always linked to one `Credit`.

Interaction details contains in `CollectorInteraction` entry. \
One `CollectorCredit` can be linked to many `CollectorInteraction` entries.

Domain entries:

```
  Collector:
    id: Long
    firstName: String
    lastName: String
    activityStatus: CollectorActivityStatus
  
  CollectorCredit:
    id: Long
    creditId: Long
    collectorId: Long
    status: CollectorCreditStatus
    statusDate: LocalDateTime
  
  CollectorInteraction:
    id: Long
    collectorCreditId: Long
    interactionDate: LocalDateTime
    interactionType: CollectorInteractionType
    interactionStatus: CollectorInteractionStatus    
      
  CollectorActivityStatus:
    IN_WORK
    ON_PAUSE
    NOT_IN_WORK
    
  CollectorCreditStatus:
    WAIT_COLLECTION
    IN_COLLECTION
    COLLECTED
  
  CollectorInteractionType:
    CALL_TO_BORROWER
    CALL_TO_EMPLOYER
    CALL_TO_FAMILY_PERSON
    VISIT_HOME    
           
  CollectorInteractionStatus:
    AGREED
    NOT_AGREED  
    TRIED_BUT_NOT_INTERACTED    
```
