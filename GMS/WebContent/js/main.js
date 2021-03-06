"use strict";

/*======== Doucument Ready Function =========*/
jQuery(document).ready(function () {



    // $(document).ready(function () {
    //     $(function () {
    //         $('.sidebar li').click(function (e) {
    //             e.preventDefault();
    //             $('li').removeClass('active');
    //             $(this).addClass('active');
    //         });
    //     });
    // });

    /*--------------------------------
         Mailbox Star
     --------------------------------*/
    $('.mail_list table .star i').click(function(e) {
        $(this).toggleClass("fa-star fa-star-o");
    });

    //CACHE JQUERY OBJECTS
    var $window = $(window);

    $window.on( 'load', function () {
        /*======== Preloader =========*/

        $(".loading-text").fadeOut();
        $(".loading").delay(350).fadeOut("slow");

        /* END of Preloader */

    });

    // Mailbox read mail Link

    $(".clickable-row").click(function() {
        window.location = $(this).data("href");
    });

    /*================================
    sidebar collapsing
    ==================================*/
    $('.nav-btn').on('click', function() {
        $('.page-container').toggleClass('sidebar_collapsed');
    });

    /*================================
    sidebar menu
    ==================================*/
    $("#menu").metisMenu();

    $(".vz_mobile_menu_icon").on("click", function() {
        $(this).toggleClass("on");
    });
    $("#vz_mobileCollapseIcon").on("click", function() {
        $(".vz_navbar").toggleClass("navbar-collapsed");
    });
    new PerfectScrollbar(".navbar-content", {
        wheelSpeed: 1,
        swipeEasing: 0,
        suppressScrollX: !0,
        wheelPropagation: 1,
        minScrollbarLength: 40
    });
    $("#vz_mobileCollapseIcon,#vz_mobileCollapseIconMobile").click(function(e) {
        $(window)[0].innerWidth < 992 && ($(".vz_navbar").toggleClass("mob-open"), e.stopPropagation());
    });

    $(window).ready(function() {
        $(".vz_main_header").on("click", function() {
            $(window)[0].innerWidth < 992 && 1 === $(".vz_navbar").hasClass("mob-open") && ($(".vz_navbar").removeClass("mob-open"),
                $("#vz_mobileCollapseIcon,#vz_mobileCollapseIconMobile").removeClass("on"));
        }), $("#vz_mobile_head").on("click", function() {
            $(".navbar-collapse,.mobile_header").slideToggle();
        });
    });

    
    $(".vz_main_sec .toggle-sidebar").on("click", function() {
        $(this);
        $(".vz_navbar").toggleClass("hide-sidebar");
    });

    /*================================
    stickey Header
    ==================================*/
    $(window).on('scroll', function() {
        var scroll = $(window).scrollTop(),
            mainHeader = $('#sticky-header'),
            mainHeaderHeight = mainHeader.innerHeight();

        // console.log(mainHeader.innerHeight());
        if (scroll > 1) {
            $("#sticky-header").addClass("sticky-menu");
        } else {
            $("#sticky-header").removeClass("sticky-menu");
        }
    });
    /*================================
    Start Footer resizer
    ==================================*/
    var e = function() {
        var e = (window.innerHeight > 0 ? window.innerHeight : this.screen.height) - 5;
        (e -= 67) < 1 && (e = 1), e > 67 && $(".main-content").css("min-height", e + "px")
    };
    $(window).ready(e), $(window).on("resize", e);

    /*================================
    form bootstrap validation
    ==================================*/
    $('[data-toggle="popover"]').popover()

    /*------------- Start form Validation -------------*/
    window.addEventListener('load', function() {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);

    /*================================
    Fullscreen Page
    ==================================*/

    if ($('#full-view').length) {

        var requestFullscreen = function(ele) {
            if (ele.requestFullscreen) {
                ele.requestFullscreen();
            } else if (ele.webkitRequestFullscreen) {
                ele.webkitRequestFullscreen();
            } else if (ele.mozRequestFullScreen) {
                ele.mozRequestFullScreen();
            } else if (ele.msRequestFullscreen) {
                ele.msRequestFullscreen();
            } else {
                console.log('Fullscreen API is not supported.');
            }
        };

        var exitFullscreen = function() {
            if (document.exitFullscreen) {
                document.exitFullscreen();
            } else if (document.webkitExitFullscreen) {
                document.webkitExitFullscreen();
            } else if (document.mozCancelFullScreen) {
                document.mozCancelFullScreen();
            } else if (document.msExitFullscreen) {
                document.msExitFullscreen();
            } else {
                console.log('Fullscreen API is not supported.');
            }
        };

        var fsDocButton = document.getElementById('full-view');
        var fsExitDocButton = document.getElementById('full-view-exit');

        fsDocButton.addEventListener('click', function(e) {
            e.preventDefault();
            requestFullscreen(document.documentElement);
            $('body').addClass('expanded');
        });

        fsExitDocButton.addEventListener('click', function(e) {
            e.preventDefault();
            exitFullscreen();
            $('body').removeClass('expanded');
        });
    }

    /*================================
    slider-area background setting
    ==================================*/
    $('.settings-btn, .offset-close').on('click', function() {
        $('.offset-area').toggleClass('show_hide');
        $('.settings-btn').toggleClass('active');
    });

    /*================================
    login form
    ==================================*/
    $('.form-gp input').on('focus', function() {
        $(this).parent('.form-gp').addClass('focused');
    });
    $('.form-gp input').on('focusout', function() {
        if ($(this).val().length === 0) {
            $(this).parent('.form-gp').removeClass('focused');
        }
    });

    
});


"use strict";

/*======== Doucument Ready Function =========*/
jQuery(document).ready(function () {



    // $(document).ready(function () {
    //     $(function () {
    //         $('.sidebar li').click(function (e) {
    //             e.preventDefault();
    //             $('li').removeClass('active');
    //             $(this).addClass('active');
    //         });
    //     });
    // });

    /*--------------------------------
         Mailbox Star
     --------------------------------*/
    $('.mail_list table .star i').click(function(e) {
        $(this).toggleClass("fa-star fa-star-o");
    });

    //CACHE JQUERY OBJECTS
   // var $window = $(window);

    //$window.on( 'load', function () {
        /*======== Preloader =========*/

       // $(".preloader").fadeOut();
     //  $(".preloader").delay(350).fadeOut("slow");

        /* END of Preloader */

   // });

    // Mailbox read mail Link

    $(".clickable-row").click(function() {
        window.location = $(this).data("href");
    });

    /*================================
    sidebar collapsing
    ==================================*/
    $('.nav-btn').on('click', function() {
        $('.page-container').toggleClass('sidebar_collapsed');
    });

    /*================================
    sidebar menu
    ==================================*/
    $("#menu").metisMenu();

    $(".vz_mobile_menu_icon").on("click", function() {
        $(this).toggleClass("on");
    });
    $("#vz_mobileCollapseIcon").on("click", function() {
        $(".vz_navbar").toggleClass("navbar-collapsed");
    });
    new PerfectScrollbar(".navbar-content", {
        wheelSpeed: 1,
        swipeEasing: 0,
        suppressScrollX: !0,
        wheelPropagation: 1,
        minScrollbarLength: 40
    });
    $("#vz_mobileCollapseIcon,#vz_mobileCollapseIconMobile").click(function(e) {
        $(window)[0].innerWidth < 992 && ($(".vz_navbar").toggleClass("mob-open"), e.stopPropagation());
    });

    $(window).ready(function() {
        $(".vz_main_header").on("click", function() {
            $(window)[0].innerWidth < 992 && 1 === $(".vz_navbar").hasClass("mob-open") && ($(".vz_navbar").removeClass("mob-open"),
                $("#vz_mobileCollapseIcon,#vz_mobileCollapseIconMobile").removeClass("on"));
        }), $("#vz_mobile_head").on("click", function() {
            $(".navbar-collapse,.mobile_header").slideToggle();
        });
    });

    
    $(".vz_main_sec .toggle-sidebar").on("click", function() {
        $(this);
        $(".vz_navbar").toggleClass("hide-sidebar");
    });

    /*================================
    stickey Header
    ==================================*/
    $(window).on('scroll', function() {
        var scroll = $(window).scrollTop(),
            mainHeader = $('#sticky-header'),
            mainHeaderHeight = mainHeader.innerHeight();

        // console.log(mainHeader.innerHeight());
        if (scroll > 1) {
            $("#sticky-header").addClass("sticky-menu");
        } else {
            $("#sticky-header").removeClass("sticky-menu");
        }
    });
    /*================================
    Start Footer resizer
    ==================================*/
    var e = function() {
        var e = (window.innerHeight > 0 ? window.innerHeight : this.screen.height) - 5;
        (e -= 67) < 1 && (e = 1), e > 67 && $(".main-content").css("min-height", e + "px")
    };
    $(window).ready(e), $(window).on("resize", e);

    /*================================
    form bootstrap validation
    ==================================*/
    $('[data-toggle="popover"]').popover()

    /*------------- Start form Validation -------------*/
    window.addEventListener('load', function() {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);

    /*================================
    Fullscreen Page
    ==================================*/

    if ($('#full-view').length) {

        var requestFullscreen = function(ele) {
            if (ele.requestFullscreen) {
                ele.requestFullscreen();
            } else if (ele.webkitRequestFullscreen) {
                ele.webkitRequestFullscreen();
            } else if (ele.mozRequestFullScreen) {
                ele.mozRequestFullScreen();
            } else if (ele.msRequestFullscreen) {
                ele.msRequestFullscreen();
            } else {
                console.log('Fullscreen API is not supported.');
            }
        };

        var exitFullscreen = function() {
            if (document.exitFullscreen) {
                document.exitFullscreen();
            } else if (document.webkitExitFullscreen) {
                document.webkitExitFullscreen();
            } else if (document.mozCancelFullScreen) {
                document.mozCancelFullScreen();
            } else if (document.msExitFullscreen) {
                document.msExitFullscreen();
            } else {
                console.log('Fullscreen API is not supported.');
            }
        };

        var fsDocButton = document.getElementById('full-view');
        var fsExitDocButton = document.getElementById('full-view-exit');

        fsDocButton.addEventListener('click', function(e) {
            e.preventDefault();
            requestFullscreen(document.documentElement);
            $('body').addClass('expanded');
        });

        fsExitDocButton.addEventListener('click', function(e) {
            e.preventDefault();
            exitFullscreen();
            $('body').removeClass('expanded');
        });
    }

    /*================================
    slider-area background setting
    ==================================*/
    $('.settings-btn, .offset-close').on('click', function() {
        $('.offset-area').toggleClass('show_hide');
        $('.settings-btn').toggleClass('active');
    });

    /*================================
    login form
    ==================================*/
    $('.form-gp input').on('focus', function() {
        $(this).parent('.form-gp').addClass('focused');
    });
    $('.form-gp input').on('focusout', function() {
        if ($(this).val().length === 0) {
            $(this).parent('.form-gp').removeClass('focused');
        }
    });
});



