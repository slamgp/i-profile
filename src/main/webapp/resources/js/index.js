var LoginModalController = {
    tabsElementName: ".logmod__tabs li",
    tabElementName: ".logmod__tab",
    inputElementsName: ".logmod__form .input",
    hidePasswordName: ".hide-password",
    
    inputElements: null,
    tabsElement: null,
    tabElement: null,
    hidePassword: null,
    
    activeTab: null,
    tabSelection: 0, // 0 - first, 1 - second
    
    findElements: function () {
        var base = this;
        
        base.tabsElement = $(base.tabsElementName);
        base.tabElement = $(base.tabElementName);
        base.inputElements = $(base.inputElementsName);
        base.hidePassword = $(base.hidePasswordName);
        
        return base;
    },
    
    setState: function (state) {
        var base = this,
            elem = null;
        
        if (!state) {
            state = 0;
        }
        
        if (base.tabsElement) {
            elem = $(base.tabsElement[state]);
            elem.addClass("current");
            $("." + elem.attr("data-tabtar")).addClass("show");
        }
  
        return base;
    },
    
    getActiveTab: function () {
        var base = this;
        
        base.tabsElement.each(function (i, el) {
           if ($(el).hasClass("current")) {
               base.activeTab = $(el);
           }
        });
        
        return base;
    },
   
    addClickEvents: function () {
        var base = this;
        
        base.hidePassword.on("click", function (e) {
            var $this = $(this),
                $pwInput = $this.prev("input");
            
            if ($pwInput.attr("type") == "password") {
                $pwInput.attr("type", "text");
                $this.text("Hide");
            } else {
                $pwInput.attr("type", "password");
                $this.text("Show");
            }
        });
 
        base.tabsElement.on("click", function (e) {
            var targetTab = $(this).attr("data-tabtar");
            
            e.preventDefault();
            base.activeTab.removeClass("current");
            base.activeTab = $(this);
            base.activeTab.addClass("current");
            
            base.tabElement.each(function (i, el) {
                el = $(el);
                el.removeClass("show");
                if (el.hasClass(targetTab)) {
                    el.addClass("show");
                }
            });
        });
        
        base.inputElements.find("label").on("click", function (e) {
           var $this = $(this),
               $input = $this.next("input");
            
            $input.focus();
        });
        
        return base;
    },
  
    divContentRequestPOST: function () {
        $.ajax({
            url: '/sport/content',
            type: 'POST',            
            dataType : 'json',     
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function (data, textStatus) {
                alert("data " + data);
                $("#mainContext").html(data.name);
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    },
    
    divContentRequest: function divContentRequest() {
        var redirect = '/i-profile/welcome';
        history.pushState('', '', redirect);
		var mail =  $('.logmod__tab.lgm-2').find('#user-email')[0].value;
		var pass =  $('.logmod__tab.lgm-2').find('#user-pw')[0].value;
    	$.get(redirect, {"name": pass, "mail": mail}, function( data ) {
            $('.logmod').html(data);
        });
    },

    initialize: function () {
        var base = this;
        var buttons = $('.logmod__tab.lgm-2').find('.sumbit');
        buttons.on('click', function(){
            base.divContentRequest();
        });
        base.findElements().setState().getActiveTab().addClickEvents();
    }
};

$(document).ready(function() {
    LoginModalController.initialize();
});