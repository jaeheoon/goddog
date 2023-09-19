package tteogipbangbeomdae.goddog.domain.openapi.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tteogipbangbeomdae.goddog.domain.dog.dto.Dog;

/**
 * OpenAPI 관련 비즈니스 구현 클래스
 *
 * @author  떡잎방범대 홍재헌
 * @since   2023. 9. 12.
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
public class OpenApiServiceImpl implements OpenApiService{
	
	/** OpenAPI 이용하여 강아지 리스트 불러오는 메소드 */
	@Override
	public List<Dog> getDogList(String pageNo) {
		List<Dog> dogList = new ArrayList<Dog>();
		StringBuilder sb = new StringBuilder();
	     
	       try {
	    	   StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic"); /*URL*/
	           urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=akTdA6bI7qrFaVDNLP%2BSmmO0iqjbLVr6ff3e3zCcvKWVCtW%2B%2BmG2WQwnFVcsSjYMJPPRn54XgDA66FM2XgO1vQ%3D%3D"); /*Service Key*/
	           urlBuilder.append("&" + URLEncoder.encode("upkind","UTF-8") + "=" + URLEncoder.encode("417000", "UTF-8")); /*축종 코드(개 : 417000)*/
	           urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("9", "UTF-8")); /*한 페이지 결과 수(1,000 이하)*/
	           urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo, "UTF-8")); /*페이지 번호*/
	           urlBuilder.append("&" + URLEncoder.encode("_type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml(기본값) 또는 json*/
	           URL url = new URL(urlBuilder.toString());
	           HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
	           urlConnection.setRequestMethod("GET");
	           urlConnection.setRequestProperty("Content-type", "application/json");
	           
	           BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
	           
	           String line = null;
	           while ((line = bf.readLine()) != null) {
	               sb.append(line);
	           }
	           bf.close();
	           
	           JSONParser jsonParser = new JSONParser();
	           JSONObject jsonObject = (JSONObject)jsonParser.parse(sb.toString());
	           JSONObject response = (JSONObject)jsonObject.get("response");
	           JSONObject body = (JSONObject)response.get("body");
	           JSONObject items = (JSONObject)body.get("items");
	           JSONArray jsonArray = (JSONArray)items.get("item");
	           for (int i = 0; i < jsonArray.size(); i++) {
	        	   JSONObject object = (JSONObject) jsonArray.get(i);
	        	   String desertionNo = (String) object.get("desertionNo");		//강아지 번호
	        	   String happenDt = (String) object.get("happenDt");			//접수일
	        	   String happenPlace = (String) object.get("happenPlace");		//발견장소
	        	   String orgNm = (String) object.get("orgNm");					//시군구
	        	   String kindCd = (String) object.get("kindCd");				//품종
	        	   String colorCd = (String) object.get("colorCd");				//색상
	        	   String age = (String) object.get("age");						//나이
	        	   String weight = (String) object.get("weight");				//체중
	        	   String popfile = (String) object.get("popfile");				//Image
	        	   String processState = (String) object.get("processState");	//보호중
	        	   String sexCd = (String) object.get("sexCd");					//성별
	        	   String neuterYn = (String) object.get("neuterYn");			//중성화여부
	        	   String specialMark = (String) object.get("specialMark");		//특징
	        	   String careAddr = (String) object.get("careAddr");			//보호장소
	        	   String noticeNo = (String) object.get("noticeNo");			//공고번호
	        	   String noticeComment = (String) object.get("noticeComment");	//특이사항
	        	   String noticeSdt = (String) object.get("noticeSdt");			//공고시작일
	        	   String noticeEdt = (String) object.get("noticeEdt");			//공고종료일
	        	   Long totalCount = (Long) body.get("totalCount");
	        	   String kind = kindCd.replace("[개] ", "");
//	        	   if (sexCd.equals("M")) {
//	        		   sexCd = "수컷";
//	        	   } else {
//	        		   sexCd = "암컷";
//	        	   }
	        	   Dog dog = Dog.builder()
	        			   		.desertionNo(desertionNo)
	        			   		.happenDt(happenDt)
	        			   		.happenPlace(happenPlace)
	        			   		.orgNm(orgNm)
	        			   		.kindCd(kind)
	        			   		.colorCd(colorCd)
	        			   		.age(age)
	        			   		.weight(weight)
	        			   		.popfile(popfile)
	        			   		.processState(processState)
	        			   		.sexCd(sexCd)
	        			   		.neuterYn(neuterYn)
	        			   		.specialMark(specialMark)
	        			   		.careAddr(careAddr)
	        			   		.noticeNo(noticeNo)
	        			   		.noticeComment(noticeComment)
	        			   		.noticeSdt(noticeSdt)
	        			   		.noticeEdt(noticeEdt)
	        			   		.totalCount(totalCount)
	        			   		.build();
	        	   dogList.add(dog);
	           }
	       }catch(Exception e) {
	           e.printStackTrace();
	       }
		return dogList;
	}
}
