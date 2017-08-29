package com.hauxin.shop.web.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.util.Streams;

/**
 * @author @DT人 2017年7月19日 下午8:52:43
 *
 */
@WebServlet("/file")
public class FileServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// 检测一个上传请求的文件
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		System.out.println(isMultipart);
		FileOutputStream fos = null; // 文件输出流做上传文件,上传完成要关闭流
		InputStream stream = null; // io提供的流对象
		try {
			if(isMultipart) { // 判断是否是
				// 创建一个新的文件上传操作
				ServletFileUpload upload = new ServletFileUpload();
				// 转换请求成迭代器
				FileItemIterator iter = upload.getItemIterator(req);
				while(iter.hasNext()) {
					FileItemStream fis = iter.next();
					stream = fis.openStream(); // 把文件流变成输入流对象
					if(fis.isFormField()) { // isFormField方法用来判断是否是普通的表单域
						// 如果是表单域可以获得表单域的名称
						System.out.print(fis.getFieldName()+"=============");
						// 通过IO红的Streams类的asString方法可以把流中的数据转换成String
						System.out.println(Streams.asString(stream));
					} else {
						// 否则可以得到文件的名称
						System.out.println(fis.getName());
						String path = req.getSession().getServletContext().getRealPath("/upload");
						path = path + "/" + fis.getName(); // 这个路径会创建一个临时空间的realpath,而不是真正项目upload的realpath
						System.out.println(path);
						// 有了上面的输入流stream，就可以实现上传了
						fos = new FileOutputStream(path);
						byte[] buf = new byte[1024];
						int len = 0;
						while((len = stream.read(buf)) > 0) { // 只要大于0就表示有数据
							fos.write(buf, 0 , len);
						}
					}
				}
			} 
		} catch (FileUploadException e) {
			e.printStackTrace();
		} finally {
			if(stream != null) stream.close();
			if(fos != null) fos.close();
		}
	}
}
