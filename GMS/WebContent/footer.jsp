<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<footer>
        <div class="footer-area">
            <p>© Copyright 2019. All right reserved.</p>
        </div>
    </footer>
    
    <script src="js/jquery.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/metisMenu.min.js"></script>
	<script src="js/jquery.slimscroll.min.js"></script>
	<script src="js/perfect-scrollbar.min.js"></script>
	<script src="js/jquery.slicknav.min.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/validate.js"></script>
	<script src="js/select2.js"></script>
	<script src="vendors/sweetalert2/js/sweetalert2.all.min.js"></script>
	<script src="js/init/sweet-alert.js"></script>
	<script src="js/bootstrap-tooltip.js"></script>
	<script src="js/bootstrap-confirmation.js"></script>
	<script src="js/main.js"></script>
	<style id='antiClickjack'>
    	body{display:none !important;}
	</style>
	<script type='text/javascript'>
	    if (self === top) {
	    var antiClickjack = document.getElementById('antiClickjack');
	    antiClickjack.parentNode.removeChild(antiClickjack);
	    } else {
	    top.location = self.location;
	    }
	</script>
	<script>
	$(function(){
		var userAgent = navigator.userAgent.toLowerCase();
		if (userAgent.indexOf("chrome") != -1){
			$('body').addClass('chrome');
		}
	});
	</script>
	<script>
	function isIE() {
		  ua = navigator.userAgent;
		  var is_ie = ua.indexOf("MSIE ") > -1 || ua.indexOf("Trident/") > -1;
		  return is_ie;
		}
		if (isIE()){
		    $('body').addClass('ie');
		}else{
		    $('body').addClass('notie');
		}
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
	    	$('.datepicker').datepicker();
	    	autoclose: true
		});
	</script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>	
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.css">	
