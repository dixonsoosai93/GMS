	var row=[];
	$("body").on("click", "#empCheck", function () { 
			row=$(".main input:checked").parents("tr");
	});
    var rowIdx = 0; 
	$("#select").click(function () {
		for(var i = row.length-1; i > -1 ; i--){ 
	    console.log("empGriv :"+row[i]);
        $("#empEntry").append(`<tr id="R${++rowIdx}"> 
             <td class="row-index align-bottom"> 
             <p class="align-center">${rowIdx}</p> 
             </td> 
             <td>${row[i].cells[4].innerHTML}</td>
             <td>${row[i].cells[2].innerHTML}</td>
             <td>${row[i].cells[7].innerHTML}</td>
             <td>${row[i].cells[9].innerHTML}</td>
              <td class="text-center"> 
                <button class="btn remove"
                  type="button"><i class="ti-trash"></i></button> 
                </td> 
              </tr>`);
             }
		});
    	  
    $('#empEntry').on('click', '.remove', function () { 
    	if(confirm("do you want to delete")){
    		var child = $(this).closest('tr').nextAll(); 
    		child.each(function () {  
    		var id = $(this).attr('id'); 
    		var idx = $(this).children('.row-index').children('p'); 
    		var dig = parseInt(id.substring(1)); 
    		idx.html(`${dig - 1}`);  
    		$(this).attr('id', `R${dig - 1}`); 
    		});  
    	$(this).closest('tr').remove(); 
    	rowIdx--; 
    	}
    }); 