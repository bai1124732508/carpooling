$(function (){
	//粒子背景特效
    $('body').particleground({
        dotColor: '#E8DFE8',
        lineColor: '#133b88'
    });
    
    $(document).keypress(function (e) {
        // 回车键事件  
        if (e.which == 13) {
            $('#submit').click();
        }
    });
    
    
    $('#submit').click(function () {
    	 var login = $('input[name="login"]').val();
         var pwd = $('input[name="pwd"]').val();
         if (login == '') {
             ErroAlert('请输入您的账号');
         } else if (pwd == '') {
             ErroAlert('请输入密码');
         }else {
        	 //认证中..
             //  fullscreen();
               $('.login').addClass('test'); //倾斜特效
               setTimeout(function () {
                   $('.login').addClass('testtwo'); //平移特效
               }, 300);
               setTimeout(function () {
                   $('.authent').show().animate({ right: -320 }, {
                       easing: 'easeOutQuint',
                       duration: 600,
                       queue: false
                   });
                   $('.authent').animate({ opacity: 1 }, {
                       duration: 200,
                       queue: false
                   }).addClass('visible');
                   $("#loginform").submit();
               }, 500);
         }
    });
	
});