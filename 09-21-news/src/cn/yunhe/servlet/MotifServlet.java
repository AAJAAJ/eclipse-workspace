package cn.yunhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import cn.yunhe.controller.MotifController;
import cn.yunhe.entity.Motif;
import cn.yunhe.entity.Paging;

public class MotifServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//先获取标识,判断当前的操作类型
		String type = request.getParameter("type");
		
		MotifController motifController = new MotifController();
		if("add".equals(type)){
			addMotif(request,response,motifController);
		}else if("update".equals(type)){
			updateMotif(request,response,motifController);
		}else if("query".equals(type)){
			queryMotif(request,response,motifController,session);
		}
	}

	/**
	 * 添加主题
	 * @param request
	 * @param response
	 * @param motifController
	 */
	public void addMotif(HttpServletRequest request, HttpServletResponse response,MotifController motifController) {
		try {
			String motifName = new String(request.getParameter("motifName").getBytes("iso-8859-1"),"utf-8");
			Motif motif = new Motif();
			motif.setMotif(motifName);
			int result = motifController.addMotif(motif);
			if(result == 1){
				response.sendRedirect("motif-list.jsp");
			}else{
				response.sendRedirect("motif-list.jsp");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改主题状态
	 * @param request
	 * @param response
	 * @param motifController
	 */
	public void updateMotif(HttpServletRequest request, HttpServletResponse response,MotifController motifController) {
		try {
			String id = request.getParameter("id");
			String state = request.getParameter("state");
			state = String.valueOf(Integer.valueOf(state)==0?1:0);
			motifController.delMotifById(state,Integer.valueOf(id));
			response.sendRedirect("motif-list.jsp");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询所有的主题信息
	 * @param request
	 * @param response
	 * @param motifController
	 * @param session
	 */
	public void queryMotif(HttpServletRequest request, HttpServletResponse response,MotifController motifController,HttpSession session) {
		
		try {
			PrintWriter out = response.getWriter();
			//获取数据总条数
			int total = motifController.getCount();
			//每页展示的数据条数
			int pageCount = 3;
			//默认页码
			int pageIndex = 1;
			//获取分页的页码数
			String newPageIndex = request.getParameter("pageIndex");
			if(newPageIndex != null){
				pageIndex = Integer.valueOf(newPageIndex);
			}
			List<Motif> motifList = motifController.queryMotifList(pageCount, pageIndex);
			//将分页相关的数据封装到对象中
			Paging paging = new Paging();
			paging.setPageCount(pageCount);
			paging.setTotal(total);
			paging.setPageIndex(pageIndex);
			paging.setList(motifList);
			
			out.print(JSON.toJSONString(paging));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
