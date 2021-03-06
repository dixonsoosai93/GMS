/* ========================================================================

Data Table Init

=========================================================================
 */

jQuery(document).ready(function () {
	$.fn.dataTable.moment('DD-MM-YYYY');
	var table = $('#dataTable2').DataTable({        
        "scrollY": 300,
        "scrollX": true,
        fixedHeader: true,
    });
    /*var table = $('#alternateInv').DataTable({        
        "scrollY": 300,
        "scrollX": true,
        fixedHeader: true,
    });*/
    /*var table = $('#EmpSearch').DataTable({        
        "scrollY": 300,
        "scrollX": true,
        fixedHeader: true,
    });*/
    var table = $('#Grv_Report').DataTable({        
        "scrollY": 300,
        "scrollX": true,
        "destroy": true,
        fixedHeader: true,
    });
    /*var table = $('#dataTable').DataTable({        
        "scrollY": 300,
        "scrollX": true,
        fixedHeader: true,
    });*/
    /*var table = $('#compList').DataTable({        
        "scrollY": true,
        "scrollX": true,
        fixedHeader: true,
    });var table = $('#invList').DataTable({        
        "scrollY": 300,
        "scrollX": true,
        fixedHeader: true,
    });*/
    var table = $('#grvCaseList').DataTable({        
        "scrollY": 300,
        "scrollX": true,
        fixedHeader: true,
    });/*
    var table = $('#dataTable3').DataTable({        
        "scrollY": 300,
        "scrollX": true,
        fixedHeader: true,
    });
    /*var table = $('#EmpTable').DataTable({        
        "scrollY": 300,
        "scrollX": true,
        fixedHeader: true,
    });*/
    /*var table = $('#AddGrievance').DataTable({        
        "scrollY": 300,
        "scrollX": true,
        fixedHeader: true,
    });
    */
    /*var table = $('#grievance').DataTable({  
    	"scrollY": true,
        "scrollX": true,
        fixedHeader: true,
    });
    /*
    var table = $('#gridCase').DataTable({        
        "scrollY": 300,
        "scrollX": true,
        fixedHeader: true,
    });
    var table = $('#results').DataTable({        
        "scrollY": 300,
        "scrollX": true,
        fixedHeader: true,
    });*/
    var table = $('#rhrDataTable').DataTable({        
        "scrollY": 300,
        "scrollX": true,
        fixedHeader: true,
    });

    var table = $('#zlgcDataTable').DataTable({        
        "scrollY": 300,
        "scrollX": true,
        fixedHeader: true,
    });

    var table = $('#centcomDataTable').DataTable({        
        "scrollY": 300,
        "scrollX": true,
        fixedHeader: true,
    });

    var table = $('#xyz').DataTable({        
        "scrollY": 300,
        "scrollX": true,
        fixedHeader: true,
    });

    var table = $('#reopenClosed').DataTable({        
        "scrollY": 300,
        "scrollX": true,
        fixedHeader: true,
    });
});

"use strict";


/*======== Doucument Ready Function =========*/
jQuery(document).ready(function () {
	

    //CACHE JQUERY OBJECTS
    var $window = $(window);

    /*================================
            datatable active
    ==================================*/
    if ($('#dataTable').length) {
        $('#dataTable').DataTable();
    }
    if ($('#dataTable2').length) {
        $('#dataTable2').DataTable();
        
        
    }
    if ($('#dataTable3').length) {
        $('#dataTable3').DataTable();
    }

});
/*======== End Doucument Ready Function =========*/