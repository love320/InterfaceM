//冰迪
$(function(){
	 
	var paralisturl = $("#paralisturl").attr("value");
	var faceid = $("#faceid").attr("value");
	//处理输入参数
	TemplateToData(paralisturl,{id:faceid,species:1},"#paradiv","Template-Items");
	//处理返回参数
	TemplateToData(paralisturl, {id:faceid,species:2},"#paraReturndiv","Template-Items");
	
});

function TemplateToData(url,data,outdiv,divtem){
	
	/**处理编码（有乱码）*/
    //$("#paradiv").setTemplateElement("Template-Items").processTemplateURL(paralisturl);
	
	$.getJSON(url,data, function(json){
		var prodiv = $(outdiv);
		 // 设置模板  
		prodiv.setTemplateElement(divtem);  
         // 处理模板  
		prodiv.processTemplate(json);  
		});
}

function parameterAdd(obj,type){
	var objhtml = $("#Template-ItemsAdd").clone(true);
	var divadd = $(obj).prev();
	objhtml.find("#species").attr("value",type);
	divadd.append(objhtml);	
};

function parameterAddchild(obj){
	var objhtml = $("#Template-ItemsAdd").clone(true);
	var pobj = $(obj).parent().parent();
	objhtml = paratypeobj(pobj,objhtml);
	objhtml = paraiconchild(pobj,objhtml);
	pobj.after(objhtml);
	
};

//处理参数类型,设置上级层id保持与类型
function paratypeobj(beobj,obj){
	obj = $(obj);
	var paraid = beobj.find("#paraid").attr("value");
	obj.find("#superior").attr("value",paraid);
	
	var species = beobj.find("#species").attr("value");
	obj.find("#species").attr("value",species);
	
	return obj;
};

//加入级层
function paraiconchild(obj,objhtml){
	//获取但前层级
	obj = $(obj);
	var icons = obj.find(".icon-minus");
	//.size()  <i class="icon-minus"></i>
	var select = objhtml.find("#superior");
	for(i = 0;i<=icons.size();i++){
		select.after(' <i class="icon-minus"></i>');
	}
	return objhtml;
};


function parameterDelete(obj){
	var pobj = $(obj).parent().parent();
	var paradeleteurl = $("#paradeleteurl").attr("value");
	
	var id = pobj.find("#paraid").attr("value");
	$.get(paradeleteurl,{id:id}, function(data){
		  pobj.slideUp("slow",function(){
			  pobj.remove();
		  });
		});
};

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
		jobj.next().next().show();
     }, 1000);
	
};


function parameterSavePost(obj){
	var jobj = $(obj);
	var faceid = $("#faceid").attr("value");
	var species = jobj.find("#species").attr("value");
	var superior =  jobj.find("#superior").attr("value");
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
		   data: { id:id,species:species,faceid:faceid,superior:superior,type: type, isnull:isnull,name:name,nametext:nametext },
		   success: function(json){
			   if(json.code == 1){
			    	 jobj.find("#paraid").attr("value",json.id);
			     	}
		     }
		});

};

