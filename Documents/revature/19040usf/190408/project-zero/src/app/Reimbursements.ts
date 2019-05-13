export class Reimbursements {   
    reimbId: number; 
    reimbAmount: number; 
    reimDescription: string;
    reimbAuthor: number;    
    reimbResolver: number;   
    reimbStatusId: number;   
    reimbTypeId: number;   
       

    constructor(reimbId: number, reimbAmount: number, reimDescription:string,
         reimbAuthor: number, reimbResolver: number, 
         reimbStatusId: number, reimbTypeId: number) 
         {       
            this.reimbId = reimbId;                  
            this.reimbAmount = reimbAmount;
            this.reimDescription = reimDescription;       
            this.reimbAuthor = reimbAuthor;       
            this.reimbResolver = reimbResolver; 
            this.reimbStatusId = reimbStatusId;  
            this.reimbTypeId = reimbTypeId;       
         }}