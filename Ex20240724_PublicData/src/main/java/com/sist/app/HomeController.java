package com.sist.app;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import data.vo.DataVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) throws Exception {
		URL url = new URL("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty?serviceKey=528KjHbHGy9mCKDYxlXAan09GfBI4mVvwUhKE2q2jIVcBQa%2B5wUYNZK1ZyTrWRiRziQlGQuJy5VKnGWTmwxHLA%3D%3D&returnType=xml&numOfRows=1&pageNo=1&stationName="+
								URLEncoder.encode("강남구","utf-8")+"&dataTerm=DAILY&ver=1.5");
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		// 서버로부터 받는 자원이 xml문서이므로 헤더에서 mimeType을 지정한다.
		conn.setRequestProperty("Content-Type", "application/xml");
		
		conn.connect();
		
		// 이제 요청하여 받을 자원들을 처리할 객체를 준비
		SAXBuilder builder = new SAXBuilder();
		// 이 객체를 사용하기 위해 MVNRepository.com에서
		// jdom으로 검색! (jdom2 선택) --> ver 2.0.6 > pom.xml에 추가
		
		Document doc = builder.build(conn.getInputStream());
		
		// root element 얻기
		Element root = doc.getRootElement(); // root(<response>)
		
		// root의 자식들 중 body요소를 얻어낸다.
		Element body = root.getChild("body");
		
		// body 안에 있는 items라는 요소를 얻어낸다.
		Element items = body.getChild("items");
		List<Element> item_list = items.getChildren("item");
		
		// 위의 list에 저장된 Element를 DataVO로 변환하기 위해 저장소를 준비
		List<DataVO> dvo_list = new ArrayList<DataVO>();
		for(Element e: item_list) {
			DataVO dvo = new DataVO();
			// item_list로부터 얻어낸 e는 item요소다.
			dvo.setPm10Value(e.getChildText("pm10Value"));
			dvo.setPm10Grade(e.getChildText("pm10Grade"));
			dvo.setCoValue(e.getChildText("coValue"));
			dvo.setCoGrade(e.getChildText("coGrade"));
			dvo.setKhaiValue(e.getChildText("khaiValue"));
			dvo.setKhaiGrade(e.getChildText("khaiGrade"));

			dvo.setDataTime(e.getChildText("dataTime"));

			dvo_list.add(dvo);
		}
		
		model.addAttribute("d_list", dvo_list);
		
		return "home"; // views/home.jsp를 의미함
	}
	
}
