package com.qingniao.console.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.annotate.JsonUnwrapped;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qingniao.core.common.IDUtils;

/**
 * 用来处理图片上传
 * @author Lenovo
 *
 */
@Controller
public class UploadController {
	@ResponseBody
	@RequestMapping("/upload/unloadImg.do")
	public  void upLoadImg(@RequestParam(value = "picture") MultipartFile picfile,HttpServletRequest request,
			HttpServletResponse response){
		//编写图片上传的业务逻辑方法
		//获取图片名称
		String filename =picfile.getOriginalFilename();
		//获取图片扩展名
		String ext = filename.substring(filename.lastIndexOf(".")+1);
		//生成图片名称
		String imgName=IDUtils.genImageName();
		//生成图片的储存路径
		String path ="/imgs/"+imgName+"."+ext;
		//获取服务器的绝对路径保存图片
		String url=request.getSession().getServletContext().getRealPath("")+path;
		//图片上传
		try {
			InputStream	io= picfile.getInputStream();
			OutputStream out=new FileOutputStream(new File(url));
			byte [] b=new  byte[1024];
			int len;
			while((len=io.read(b))!=-1){
				out.write(b, 0, len);
			}
			io.close();
			out.close();
			//把图片的路径使用json的格式进行返回
			JSONObject jo=new JSONObject();
			jo.put("path", path);
			response.getWriter().write(jo.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
