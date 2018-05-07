 var index = '';
$(function (){
	var valid = $("#layerform").Validform({//弹框提交关闭弹框刷新父页面
		tiptype:3,
		label:".label",
		showAllError:true,
		ajaxPost:true,
		beforeSubmit:function(){
			  //弹出loading
				index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
		},	
		callback:function(data){
			$('#Validform_msg').hide();
			$('.btn-primary').addClass('disabled').attr('autocomplete','off').prop('disabled',true);
			if(data.code == 1){	
				top.layer.close(index);
	            top.layer.msg(data.msg + ', ' + data.wait+'秒后页面将自动跳转~');
				setTimeout(function(){
		            layer.closeAll("iframe");
		            //刷新父页面
		            parent.location.reload();
		        },data.wait);
			}else{
				top.layer.close(index);
				top.layer.msg(data.msg);
				setTimeout(function(){
					$('.btn-primary').removeClass('disabled').prop('disabled',false);
				},data.wait);
			}
		}
	});
	
	$('#loginform').Validform({
		tiptype:3,
		label:".label",
		showAllError:true,
		ajaxPost:false,
		beforeSubmit:function(){
			var url = $('#loginform').attr('action');
			var f = $('#loginform').serialize();
			var password = carpooling.getUrlValue(f,'password');
			var password2 = carpooling.getUrlValue(f,'password2');
			var md5Password = hex_md5(password);
			if(password2 != null){
				var md5Password2 = hex_md5(password2);
				f = f.replace('password2='+password2,'password2='+md5Password2);
			}
			f = f.replace('password='+password,'password='+md5Password);
			
			$.post(url,f).success(function(data){
				data=JSON.parse(data);
				if(data.code == 1){
					if (data.url) {
						ErroAlert(data.msg);
						setTimeout(function(){
							location.href = data.url;
						},data.wait*1000);
					}else{
						 ErroAlert(data.msg + ',3秒后页面将是刷新页面~',data.wait,'error');
						$('.gzhuce').removeClass('disabled').prop('disabled',false);
					}
				}else{
					ErroAlert(data.msg + ',3秒后页面将是刷新页面~',data.wait,'error');
					$('.gzhuce').removeClass('disabled').prop('disabled',false);
				}
			});
			return false;
		}
	});
	
	
	
	$(".layui-btn-close").click(function (){
		parent.layer.closeAll();
	});
	
	$(".ajaxPost").click(function (){
		var url = $(this).attr("url");
		var confirmMsg = $(this).attr("confirmMsg");
		var target = $(this).attr('target-form');
		var id = $(this).attr("id");
		layer.confirm(confirmMsg,{icon:3, title:'提示信息'},function(index){
			layer.close(index);
			var loading = layer.load(1, {
				shade: [0.5,'#fff']
			});
			$.post(url,target+'='+id).success(function(data){
				layer.close(loading);
				if(data.code == 1){
					if (data.url != '' && data.url !=null ) {
						location.href = data.url;
						setTimeout(function(){
							
						},1000);
					}else{
						ErroAlert(data.msg + ',3秒后页面将是刷新页面~',data.wait,'error');
						$('.gzhuce').removeClass('disabled').prop('disabled',false);
					}
				}else{
					ErroAlert(data.msg + ',3秒后页面将是刷新页面~',data.wait,'error');
					$('.gzhuce').removeClass('disabled').prop('disabled',false);
				}
			});
			
        });
	});	
});

var carpooling={
		
		openNewHtml:function(newPageTitle,newPageUrl){
			 var index = layui.layer.open({
		            title : newPageTitle,
		            type : 2,
		            content : newPageUrl,
		            success : function(layero, index){
		                var body = layui.layer.getChildFrame('body', index);
		                setTimeout(function(){
		                    layui.layer.tips('点击此处返回', '.layui-layer-setwin .layui-layer-close', {
		                        tips: 3
		                    });
		                },500)
		            }
		        })
		        layui.layer.full(index);
			 	window.sessionStorage.setItem("index",index);
		        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
		        $(window).on("resize",function(){
		            layui.layer.full(window.sessionStorage.getItem("index"));
		        })
			
		},
		getUrlValue: function (url,name) {
			 var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
			 var r = url.match(reg);
			 if (r!=null) return (r[2]); return null;
		}
		
		
}