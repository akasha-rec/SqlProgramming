package utils;

public class BoardPage {
	public static String pagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl, String searchField, String searchWord) {
		String pagingStr = "";

		int totalPages = (int) (Math.ceil(((double) totalCount / pageSize)));
		String searchStr = "";
		if (searchWord != null) {
			searchStr = "searchField="+searchField+"&searchWord="+searchWord;
		}
		
		//이전 페이지 블록 바로가기 출력
		int pageTemp = (((pageNum - 1) / blockPage) * blockPage) +1;
		if (pageTemp != 1) {
			pagingStr += "<a href='" + reqUrl + "?pageNum=1" + "&" + searchStr+"'>[첫 페이지]</a>";
			pagingStr += "&nbsp;";
			pagingStr += "<a href='" + reqUrl + "?pageNum=" + (pageTemp - 1) + "&" + searchStr+"'>[이전 블록]</a>";
		}
		
		//각 페이지 번호 출력
		int blockCount = 1;
		while (blockCount <= blockPage && pageTemp <= totalPages) {
			if (pageTemp == pageNum) {
				
			//현재 페이지는 링크X
			pagingStr += "&nbsp;" + pageTemp + "&nbsp;";
		} else {
			pagingStr += "&nbsp;<a href='" + reqUrl + "?pageNum=" + pageTemp + "&" + searchStr+"'>" + pageTemp + "</a>&nbsp;";
		}
		pageTemp++;
		blockCount++;
	}
	
		//다음 페이지 블록 바로가기 출력
		if (pageTemp <= totalPages) {
			pagingStr += "<a href='" + reqUrl + "?pageNum=" + pageTemp + "&" + searchStr+"'>[다음 블록]</a>";
			pagingStr += "&nbsp;";
			pagingStr += "<a href='" + reqUrl + "?pageNum=" + totalPages + "&" + searchStr+"'>[마지막 페이지]</a>";
		}
		return pagingStr;
	}
}
