/*********************************
 * Themes, rules, and i18n support
 * Locale: Chinese; ����
 *********************************/
(function ($) {
    /* Global configuration
     */
    $.validator.config({
        //stopOnError: false,
        //theme: 'yellow_right',
        defaultMsg: "{0}��ʽ����ȷ",
        loadingMsg: "������֤...",
        
        // Custom rules
        rules: {
        	 digits: [/^\d+$/, "����������"]
            ,digits1: [/^([0-9.]+)$/, "����������"]
            ,digits2: [/^[0-9]*[1-9][0-9]*$/, "������������"]
            ,bw: [/^\d{8}$/, "�������λ����"]
            ,letters: [/^[a-z]*$/i, "{0}ֻ��������ĸ"]
            ,tel: [/^(?:(?:0\d{2,3}[- ]?[1-9]\d{6,7})|(?:[48]00[- ]?[1-9]\d{6}))$/, "�绰��ʽ����ȷ"]
            ,mobile: [/^1[3-9]\d{9}$/, "�ֻ��Ÿ�ʽ����ȷ"]
            ,email: [/^(?:[a-z0-9]+[_\-+.]?)*[a-z0-9]+@(?:([a-z0-9]+-?)*[a-z0-9]+.)+([a-z]{2,})+$/i, "�����ʽ����ȷ"]
            ,qq: [/^[1-9]\d{4,}$/, "QQ�Ÿ�ʽ����ȷ"]
            ,date: [/^\d{4}-\d{1,2}-\d{1,2}$/, "��������ȷ������,��:yyyy-mm-dd"]
            ,time: [/^([01]\d|2[0-3])(:[0-5]\d){1,2}$/, "��������ȷ��ʱ��,��:14:30��14:30:00"]
            ,ID_card: [/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[A-Z])$/, "��������ȷ�����֤����"]
            ,url: [/^(https?|ftp):\/\/[^\s]*$/i, "��ַ��ʽ����ȷ"]
            ,postcode: [/^[1-9]\d{5}$/, "���������ʽ����ȷ"]
            ,chinese: [/^[\u0391-\uFFE5]+$/, "����������"]
            ,fee:[/^\d+(?:\.\d{2})?$/, "����������(С�������λ����)"]
            ,username: [/^\w{3,20}$/, "������3-20λ���֡���ĸ���»���"]
             ,english:[\u0000-\u00FF] 
            ,password: [/^\S{5,16}$/, "������5-16λ�ǿհ��ַ����"]
            ,rpassword: function (){
            	 if($("#rpassword").val()!=$("#pass").val())
            		 return false;
            }
            ,accept: function (element, params){
                if (!params) return true;
                var ext = params[0];
                return (ext === '*') ||
                       (new RegExp(".(?:" + (ext || "png|jpg|jpeg|gif") + ")$", "i")).test(element.value) ||
                       this.renderMsg("ֻ����{1}��׺", ext.replace('|', ','));
            }
          //  ,remote:{ url:"${ctx}/reg1"} //��֤�û����Ƿ����                     
        }
    });

    /* Default error messages
     */
    $.validator.config({
        messages: {
            required: "{0}����Ϊ��",
            remote: "{0}�ѱ�ʹ��",
            rpassword:"�����������벻��ͬ",
            integer: {
                '*': "����������",
                '+': "������������",
                '+0': "��������������0",
                '-': "�����븺����",
                '-0': "�����븺������0"
            },
            match: {
                eq: "{0}��{1}��һ��",
                lt: "{0}����С��{1}",
                gt: "{0}�������{1}",
                lte: "{0}����С�ڻ����{1}",
                gte: "{0}������ڻ����{1}"
            },
            range: {
                rg: "������{1}��{2}����",
                gt: "��������ڻ����{1}����",
                lt: "������С�ڻ����{1}����"
            },
            checked: {
                eq: "��ѡ��{1}��",
                rg: "��ѡ��{1}��{2}��",
                gt: "������ѡ��{1}��",
                lt: "�����ѡ��{1}��"
            },
            length: {
                eq: "������{1}���ַ�",
                rg: "������{1}��{2}���ַ�",
                gt: "���������{1}���ַ�",
                lt: "������С��{1}���ַ�",
                eq_2: "",
                rg_2: "",
                gt_2: "",
                lt_2: ""
            }
        }
    });
    
    /* Themes
     */
    var TPL_ARROW = '<span class="n-arrow"><b>��</b><i>��</i></span>';
    $.validator.setTheme({
        'simple_right': {
            formClass: 'n-simple',
            msgClass: 'n-right'
        },
        'simple_bottom': {
            formClass: 'n-simple',
            msgClass: 'n-bottom'
        },
        'yellow_top': {
            formClass: 'n-yellow',
            msgClass: 'n-top',
            msgArrow: TPL_ARROW
        },
        'yellow_right': {
            formClass: 'n-yellow',
            msgClass: 'n-right',
            msgArrow: TPL_ARROW
        },
        'yellow_right_effect': {
            formClass: 'n-yellow',
            msgClass: 'n-right',
            msgArrow: TPL_ARROW,
            msgShow: function($msgbox, type){
                var $el = $msgbox.children();
                if ($el.is(':animated')) return;
                if (type === 'error') {
                    $el.css({
                        left: '20px',
                        opacity: 0
                    }).delay(100).show().stop().animate({
                        left: '-4px',
                        opacity: 1
                    }, 150).animate({
                        left: '3px'
                    }, 80).animate({
                        left: 0
                    }, 80);
                } else {
                    $el.css({
                        left: 0,
                        opacity: 1
                    }).fadeIn(200);
                }
            },
            msgHide: function($msgbox, type){
                var $el = $msgbox.children();
                $el.stop().delay(100).show().animate({
                    left: '20px',
                    opacity: 0
                }, 300, function(){
                    $msgbox.hide();
                });
            }
        }
    });
})(jQuery);