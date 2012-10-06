//冰迪
$(function(){
	 //set template and process
	var paralisturl = $("#paralisturl").attr("value");
	/**处理编码（有乱码）*/
    //$("#paradiv").setTemplateElement("Template-Items").processTemplateURL(paralisturl);
	
	var faceid = $("#faceid").attr("value");
	$.getJSON(paralisturl,{id:faceid}, function(json){
		 // 设置模板  
          $("#paradiv").setTemplateElement("Template-Items");  
          // 处理模板  
          $("#paradiv").processTemplate(json);  
		});
	
});

function parameterAdd(){
	$("#paradiv").append($("#Template-ItemsAdd").clone(true));	
}

function parameterDelete(obj){
	var pobj = $(obj).parent().parent();
	var paradeleteurl = $("#paradeleteurl").attr("value");
	
	var id = pobj.find("#paraid").attr("value");
	$.get(paradeleteurl,{id:id}, function(data){
		  pobj.slideUp("slow",function(){
			  pobj.remove();
		  });
		});
}

function btnAction(obj){
	var jobj = $(obj);
	var text = jobj.html();
	jobj.html(jobj.attr("data-loading-text"));
	jobj.attr("disabled","disabled");
	parameterSavePost(jobj.parent().parent());
	
	setTimeout(function () {
		jobj.html(jobj.attr("data-loading-text"));
		jobj.html("更新");
		jobj.removeAttr("disabled");
		jobj.next().show();
     }, 1000);
	
}


function parameterSavePost(obj){
	var jobj = $(obj);
	var faceid = $("#faceid").attr("value");
	var id = jobj.find("#paraid").attr("value");
	var type = jobj.find("#type").attr("value");
	var isnull = jobj.find("#isnull").attr("value");
	var name = jobj.find("#name").attr("value");
	var nametext = jobj.find("#nametext").attr("value");
	var parasaveurl = $("#parasaveurl").attr("value");
	
	$.ajax({
		   type: "POST",
		   url: parasaveurl,
		   dataType:"json",
		   data: { id:id,faceid:faceid,type: type, isnull:isnull,name:name,nametext:nametext },
		   success: function(json){
			   if(json.code == 1){
			    	 jobj.find("#paraid").attr("value",json.id);
			     	}
		     }
		});

}

