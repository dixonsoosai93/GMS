$(function() {
	//Add Case Status Master
	$("#addCaseStatusMaster").validate({
      rules: {      
    	  STATUSNAME: {
    	     required: true
    	  },
	      IS_ACTIVE:{
	        required:true
	      },
    },
    messages: {
    	STATUSNAME: {
	        required: "Please enter case status name.",      
	     },
	     IS_ACTIVE:{
	        required:"Please choose status"
	     },
    },
    submitHandler: function(form) {
      form.submit();
    }
  });
  //Edit Case Status Master
  $("#editCaseStatusMaster").validate({
      rules: {      
    	  EDIT_STATUSID: {
    	     required: true
    	  },      
    	  EDIT_STATUSNAME: {
    	     required: true
    	  },
    	  EDIT_IS_ACTIVE:{
	        required:true
	      },
    },
    messages: {
    	 EDIT_STATUSID: {
	        required: "Please enter case status id.",      
	     },
	     EDIT_STATUSNAME: {
 	        required: "Please enter case status name.",      
 	     },
 	    EDIT_IS_ACTIVE:{
	        required:"Please choose status"
	     },
    },
    submitHandler: function(form) {
      form.submit();
    }
  });
    $("#addGrievanceHandlingTatMaster").validate({
        rules: {      
          HIERID: {
      	     required: true
      	  },      
      	  TATDAYS: {
      	     required: true,
      	     number: true,
      	     min:1
      	     
      	  },
      	  BUFFERDAYS:{
  	        required:true,
  	        number: true,
  	        min:0
  	      },
      	  IS_ACTIVE:{
    	        required:true
    	  },
      },
      messages: {
    	  HIERID: {
  	        required: "Please enter hier id.",      
  	     },
  	     TATDAYS: {
   	        required: "Please enter tat days.",
   	     },
   	     BUFFERDAYS:{
	        required:"Please enter buffer days."
	     },
   	     IS_ACTIVE:{
  	        required:"Please choose status"
  	     },
      },
      submitHandler: function(form) {
        form.submit();
      }
    });
    $("#editGrievanceHandlingTatMaster").validate({
    	rules: {      
          EHIERID: {
    	  required: true
    	  },      
    	  ETATDAYS: {
    	     required: true,
    	     number: true,
    	     min:1
    	  },
    	  EBUFFERDAYS:{
	        required:true,
	        number: true,
	        min:1
	      },
    	  IS_ACTIVE:{
  	        required:true
  	  },
    },
    messages: {
  	     EHIERID: {
	        required: "Please enter hier id.",      
	     },
	     ETATDAYS: {
 	        required: "Please enter tat days.",
 	     },
 	     EBUFFERDAYS:{
        required:"Please enter buffer days."
         },
 	     EIS_ACTIVE:{
	        required:"Please choose status"
	     },
    },
    submitHandler: function(form) {
      form.submit();
        }
      });
    $("#addOrgHierarchy").validate({
    	rules: {      
    	HIERCODE: {
    	  required: true
    	  },      
    	  CLIENTCAPTION: {
    	     required: true
    	  },
    	  HIERNAME:{
	        required:true
	      },
	      HIERDESIGNATIONID: {
    	  required: true,
    	  number: true
    	  },      
    	  HIERORDER: {
    	     required: true,
    	     min:1,
    	     number: true
    	  },
    	  HIERCAP:{
	        required:true,
	        min:1,
	        number: true
	      },
	      INVESTIGATOR_NEEDED:{
	        required:true
	      },
    	  IS_ACTIVE:{
  	        required:true
  	  },
    },
    messages: {
    	HIERCODE: {
	        required: "Please enter hier code.",      
	     },
	     CLIENTCAPTION: {
 	        required: "Please enter client caption.",      
 	     },
 	     HIERNAME:{
         required:"Please enter hier name."
         },
         HIERDESIGNATIONID:{
	        required:"Please hier designation"
	     },
	     HIERORDER: {
	        required: "Please enter hier order.",      
	     },
	     HIERCAP: {
 	        required: "Please enter hier cap.",      
 	     },
 	     INVESTIGATOR_NEEDED:{
            required:"Please choose investigator needed."
         },
 	     IS_ACTIVE:{
	        required:"Please choose status"
	     },
    },
    submitHandler: function(form) {
      form.submit();
        }
      });
    $("#editOrgHierarchy").validate({
    	rules: {      
    	HIERCODE: {
    	  required: true
    	  },      
    	  CLIENTCAPTION: {
    	     required: true
    	  },
    	  HIERNAME:{
	        required:true
	      },
	      HIERDESIGNATIONID: {
    	  required: true,
    	  },      
    	  HIERORDER: {
    	     required: true,
    	     number: true
    	  },
    	  HIERCAP:{
	        required:true,
	        number: true
	      },
	      INVESTIGATOR_NEEDED:{
	        required:true
	      },
    	  IS_ACTIVE:{
  	        required:true
  	  },
    },
    messages: {
    	HIERCODE: {
	        required: "Please enter hier code.",      
	     },
	     CLIENTCAPTION: {
 	        required: "Please enter client caption.",      
 	     },
 	     HIERNAME:{
         required:"Please enter hier name."
         },
         HIERDESIGNATIONID:{
	        required:"Please hier designation"
	     },
	     HIERORDER: {
	        required: "Please enter hier order.",      
	     },
	     HIERCAP: {
 	        required: "Please enter hier cap.",      
 	     },
 	     INVESTIGATOR_NEEDED:{
            required:"Please choose investigator needed."
         },
 	     IS_ACTIVE:{
	        required:"Please choose status"
	     },
    },
    submitHandler: function(form) {
      form.submit();
        }
      });
    $("#ZlgcInvestigator").validate({
    	rules: {      
    	  ZONE_CODE: {
    	  required: true
    	  },      
    	  INVESTIGATOR_EMPLOYEE_ID: {
    	     required: true
    	  },
    	  IS_HR:{
	        required:true
	      },
    	  IS_ACTIVE:{
  	        required:true
  	  },
    },
    messages: {
    	ZONE_CODE: {
	        required: "Please Choose Zone Name",      
	     },
	     INVESTIGATOR_EMPLOYEE_ID: {
 	        required: "Please choose investigator employee name",      
 	     },
 	     IS_HR:{
         required:"Please choose investigator hr"
         },
 	     IS_ACTIVE:{
	        required:"Please choose status"
	     },
    },
    submitHandler: function(form) {
      form.submit();
        }
      });
    $("#addMainCategory").validate({
    	rules: {
    	  MAIN_CATEGORY_CODE: {
	      required: true
	      },      
    	  MAIN_CATEGORY_NAME: {
    	  required: true
    	  },      
    	  IS_ACTIVE:{
  	        required:true
  	  },
    },
    messages: {
    	MAIN_CATEGORY_CODE: {
 	        required: "Please enter main category code",      
 	     },
    	 MAIN_CATEGORY_NAME: {
	        required: "Please enter main category name",      
	     },
 	     IS_ACTIVE:{
	        required:"Please choose status"
	     },
    },
    submitHandler: function(form) {
      form.submit();
        }
      });
    $("#editMainCategory").validate({
    	rules: {      
    	  EMAIN_CATEGORY_NAME:{
    	  required: true
    	  },      
    	  EIS_ACTIVE:{
  	        required:true
  	  },
    },
    messages: {
    	 EMAIN_CATEGORY_NAME: {
	        required: "Please enter main category name",      
	     },
 	     EIS_ACTIVE:{
	        required:"Please choose status"
	     },
    },
    submitHandler: function(form) {
      form.submit();
        }
      });
    $("#RhrInvestigator").validate({
    	rules: {      
    	 REGION_CODE: {
    	  required: true
    	  },      
    	  INVESTIGATOR_EMPLOYEE_ID: {
    	     required: true
    	  },
    	  IS_HR:{
	        required:true
	      },
    	  IS_ACTIVE:{
  	        required:true
  	  },
    },
    messages: {
    	REGION_CODE: {
	        required: "Please Choose Region Name",      
	     },
	     INVESTIGATOR_EMPLOYEE_ID: {
 	        required: "Please choose investigator employee name",      
 	     },
 	     IS_HR:{
         required:"Please choose investigator hr"
         },
 	     IS_ACTIVE:{
	        required:"Please choose status"
	     },
    },
    submitHandler: function(form) {
      form.submit();
        }
      });
    $("#addCentralInv").validate({
    	rules: {         
    	  INVESTIGATOR_EMPLOYEE_ID: {
    	     required: true
    	  },
    	  IS_HR:{
	        required:true
	      },
    	  IS_ACTIVE:{
  	        required:true
  	  },
    },
    messages: {
	     INVESTIGATOR_EMPLOYEE_ID: {
 	        required: "Please choose investigator employee name",      
 	     },
 	     IS_HR:{
         required:"Please choose investigator hr"
         },
 	     IS_ACTIVE:{
	        required:"Please choose status"
	     },
    },
    submitHandler: function(form) {
      form.submit();
        }
      });
    $("#addHolidayMaster").validate({
    	rules: {         
    	  STATE_CODE: {
    	     required: true
    	  },
    	  HOLIDAYDATE:{
	        required:true
	      },
	      HOLIDAYNAME:{
		        required:true
		      },
    	  IS_ACTIVE:{
  	        required:true
  	  },
    },
    messages: {
    	 STATE_CODE: {
 	        required: "Please choose state name",      
 	     },
 	     HOLIDAYDATE:{
         required:"Please choose holiday date"
         },
         HOLIDAYNAME:{
             required:"Please enter holiday description"
             },
 	     IS_ACTIVE:{
	        required:"Please choose status"
	     },
    },
    submitHandler: function(form) {
      form.submit();
        }
      });
    $("#editHolidayMaster").validate({
    	rules: {         
    	  ESTATE_CODE: {
    	     required: true
    	  },
    	  EHOLIDAYDATE:{
	        required:true
	      },
	      EHOLIDAYNAME:{
		        required:true
		      },
    	  EIS_ACTIVE:{
  	        required:true
  	  },
    },
    messages: {
    	 ESTATE_CODE: {
 	        required: "Please choose state name",      
 	     },
 	     EHOLIDAYDATE:{
         required:"Please choose holiday date"
         },
         EHOLIDAYNAME:{
             required:"Please enter holiday description"
             },
 	     EIS_ACTIVE:{
	        required:"Please choose status"
	     },
    },
    submitHandler: function(form) {
      form.submit();
        }
      });
    $("#addGrievanceCategory").validate({
    	rules: {      
    	  MAIN_CATEGORY_CODE: {
    	  required: true
    	  },      
    	  SUB_CATEGORY_CODE:{
	        required:true
	      },
	      SUB_CATEGORY_NAME: {
    	  required: true
    	  },      
    	  HIERID: {
    	     required: true
    	  },
    	  CATEGORY_ORDER:{
	        required:true,
	        number: true,
     	    min:1
	        
	      },
    	  IS_ACTIVE:{
  	        required:true
  	  },
    },
    messages: {
    	MAIN_CATEGORY_CODE: {
	        required: "Please choose main category code",      
	     },
	     SUB_CATEGORY_CODE:{
         required:"Please enter sub category code."
         },
         SUB_CATEGORY_NAME:{
	        required:"Please enter sub category name."
	     },
	     HIERID: {
	        required: "Please enter hier code.",      
	     },
	     CATEGORY_ORDER: {
 	        required: "Please enter category order",      
 	     },
 	     IS_ACTIVE:{
	        required:"Please choose status"
	     },
    },
    submitHandler: function(form) {
    	form.submit();
        }
      });
    
    $("#addEmpGrievance").validate({
    	rules: { 
    	  COMPLIANT_EMPLOYEE_ID:{
    	  required: true  
    	  },
    	  COMPLIANT_EMPLOYEE_NAME:{
    		  required: true	  
    	  },
    },
    messages: {
    	COMPLIANT_EMPLOYEE_NAME:{
    		required: "Please enter employee name",   	
    	},
    	COMPLIANT_EMPLOYEE_ID:{
    		required: "Please enter employee id",   	
    	},
    },
    submitHandler: function(form) {
    	form.submit();
        }
      });
    
    $("#addRegion").validate({
    	rules: {      
    	  REGION_CODE: {
    	  required: true
    	  },      
    	  REGION_NAME: {
    	     required: true
    	  },
    	  REGION_DESC: {
    	  required: true
    	  },      
    	  EMPLOYEE_NAME: {
    	     required: true
    	  },
    },
    messages: {
 	     REGION_CODE: {
	        required: "Please enter region code",      
	     },
	     REGION_NAME: {
 	        required: "Please enter region name",      
 	     },
 	    REGION_DESC: {
	        required: "Please enter region description",      
	     },
	     EMPLOYEE_NAME: {
 	        required: "Please enter employee name",      
 	     },
 	   
    },
    submitHandler: function(form) {
      form.submit();
        }
      });
    
    $("#DtDailyDairy").validate({
        rules: {      
    	DAIRY_DETAILS: {
  	     required: true
  	    },
      },
      messages: {
      DAIRY_DETAILS: {
  	        required: "Please enter dairy details.",      
  	   },
      },
      submitHandler: function(form) {
        form.submit();
      }
    });
    $("#DecisionReport").validate({
        rules: {      
      DECISION_REPORT_CONTENT: {
  	     required: true
  	    },
      },
      messages: {
    	  DECISION_REPORT_CONTENT: {
  	        required: "Please enter decision report content.",      
  	   },
      },
      submitHandler: function(form) {
        form.submit();
      }
    });
    $("#CreateDtVerdict").validate({
        rules: {      
        	VERDICT_REPORT_CONTENT: {
  	     required: true
  	    },
      },
      messages: {
    	  VERDICT_REPORT_CONTENT: {
  	        required: "Please enter verdict report content.",      
  	   },
      },
      submitHandler: function(form) {
        form.submit();
      }
    });
    $("#EditDtDailyDairy").validate({
        rules: {      
       Edit_DAIRY_DETAILS: {
  	     required: true
  	    },
      },
      messages: {
    Edit_DAIRY_DETAILS: {
  	        required: "Please enter dairy details.",      
  	   },
      },
      submitHandler: function(form) {
        form.submit();
      }
    });
    $("#adminLogin").validate({
    	
        rules: {      
        	role: {
  	     required: true
  	    },
      },
      messages: {
    	  role: {
  	        required: "Please choose role.",      
  	   },
      },
      submitHandler: function(form) {
        form.submit();
      }
    });
});