//冰迪
$(function(){
	 //set template and process
	var paralisturl = $("#paralisturl").attr("value");
    $("#paradiv").setTemplateElement("Template-Items").processTemplateURL(paralisturl);
	
	/*$.getJSON(paralisturl, function(json){
		 // 设置模板  
          $("#paradiv").setTemplateElement("Template-Items");  
          // 处理模板  
          $("#paradiv").processTemplate(json);  
		});
	*/
});

function parameterSavePost(data){
	$.ajax({
		   type: "POST",
		   url: $("#parasaveurl").attr("value"),
		   data: data,
		   success: function(msg){
		     alert( "Data Saved: " + msg );
		   }
		});
}