//冰迪
$(function(){
	 //set template and process
	var paralisturl = $("#paralisturl").attr("value");
	/**处理编码（有乱码）*/
    //$("#paradiv").setTemplateElement("Template-Items").processTemplateURL(paralisturl);
	
	$.getJSON(paralisturl, function(json){
		 // 设置模板  
          $("#paradiv").setTemplateElement("Template-Items");  
          // 处理模板  
          $("#paradiv").processTemplate(json);  
		});
	
});

function parameterAdd(){
	$("#paradiv").append($("#Template-ItemsAdd").clone(true));

}

function btnAction(obj){
	var jobj = $(obj);
	parameterSavePost(jobj.parent().parent());
}

function parameterSavePost(obj){
	var jobj = $(obj);
	var faceid = $("#faceid").attr("value");
	var id = jobj.find("#paraid").attr("value");
	var type = jobj.find("#type").attr("value");
	var isnull = jobj.find("#isnull").attr("value");
	var name = jobj.find("#name").attr("value");
	var nametext = jobj.find("#nametext").attr("value");
	
	$.ajax({
		   type: "POST",
		   url: $("#parasaveurl").attr("value"),
		   data: { id:id,faceid:faceid,type: type, isnull:isnull,name:name,nametext:nametext },
		   success: function(msg){
		     //alert( "Data Saved: " + msg );
		   }
		});
}