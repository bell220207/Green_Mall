<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/common.jsp"%>
<style>
   	#header #header-top .search{ visibility: visible; }
   	#wrap{ height: unset; }
</style>
<script src="<c:url value='/js/productPage.js'/>" ></script>
<%@include file="include/header.jsp"%>       
        <div class="contents" id="proCt">
            <div class="cont" id="cont">                
                <div class="container" id="container">
                    <div class="proBox" id="proBox">
                    	<div id="proNav">
							<div class="navLine">
                    			<label><a href="<c:url value="/productsList"/>">전체</a></label>
                    		</div>
                    		<div class="navLine">
                    			<label><a href="<c:url value="/productsList?category=top"/>">상의</a></label>
                    			<ol>
		                            <li><a href="<c:url value="/productsList?category=top&sub_cate=half"/>">반팔</a></li>
		                            <li><a href="<c:url value="/productsList?category=top&sub_cate=long"/>">긴팔</a></li>
		                            <li><a href="<c:url value="/productsList?category=top&sub_cate=shirt"/>">셔츠</a></li>
		                            <li><a href="<c:url value="/productsList?category=top&sub_cate=hoodie"/>">후드</a></li>
		                            <li><a href="<c:url value="/productsList?category=top&sub_cate=outer"/>">아우터</a></li>
                        		</ol>
                    		</div>
                    		<div class="navLine">
                    			<label><a href="<c:url value="/productsList?category=bottom"/>">하의</a></label>
		                    	<ol>
		                            <li><a href="<c:url value="/productsList?category=bottom&sub_cate=long"/>">긴바지</a></li>
		                            <li><a href="<c:url value="/productsList?category=bottom&sub_cate=half"/>">반바지</a></li>
		                            <li><a href="<c:url value="/productsList?category=bottom&sub_cate=skirt"/>">스커트</a></li>
		                            <li><a href="<c:url value="/productsList?category=bottom&sub_cate=onepiece"/>">원피스</a></li>
		                        </ol>
                    		</div>
                    		<div class="navLine">
                    			<label><a href="<c:url value="/productsList?category=accessary"/>">악세사리</a></label>
		                    	<ol>
		                            <li><a href="<c:url value="/productsList?category=accessary&sub_cate=bag"/>">가방</a></li>
		                            <li><a href="<c:url value="/productsList?category=accessary&sub_cate=shoes"/>">신발</a></li>
		                            <li><a href="<c:url value="/productsList?category=accessary&sub_cate=hair"/>">헤어</a></li>
		                            <li><a href="<c:url value="/productsList?category=accessary&sub_cate=acc"/>">장신구</a></li>
		                            <li><a href="<c:url value="/productsList?category=accessary&sub_cate=ect"/>">기타</a></li>
		                        </ol>
                    		</div>                    		                    		
                    	</div> <!-- proNav -->
                    	
                    	<div class="proCont" id="proCont">
	                    	<div class="proUp" id="proUp">
								<div class="proPage">
									<div class="pHead">
										<div class="pImage">
											<img src="img/product_Head/${list.cont_img}.jpg" >
										</div> <!-- pImage -->
										
										<div class="pInfo">
											<div class="pTitle">
												<h4 class="pTitle-h4">${list.pro_title}</h4>
												<p>${list.price}<span>원</span></p>
											</div> <!-- pTitle -->
											
											<div class="pOption">
												<div class="dropdown">
													<button class="dropbtn" id="dropbtn" onclick="dropdown(this)">
														<span class="dropbtn_text" id="dropbtn_text">Select</span>
														<span class="dropbtn_click Material-Icons" id="dropbtn_click">arrow_drop_down</span>
													</button>
													
													<div class="dropbtn_content">
													<c:if test="${!empty list.optionList}">
														<c:forEach var="list" items="${list.optionList}" >
														<div class="ops">
															<input type="hidden" value="${list}">
															<span>${list}</span>
														</div>
														</c:forEach>
												    </c:if>
												    </div> <!-- dropdown-content -->
												</div> <!-- dropdown -->
											</div> <!-- pOption -->
															
											<div class="pPurchase">
												<div class="pQuantity">
													<input type="number" id="purchaseNum" min="${list.minNum}" max="${list.maxNum}">
													<button type="button" class="qBtn" id="up" onclick="purchaseNum(this)"><span>expand_less</span></button>
													<button type="button" class="qBtn" id="down" onclick="purchaseNum(this)"><span>expand_more</span></button>
												</div>
												<div class="pCart"><button type="button">Cart</button></div>												
												<div class="pOrder"><button type="button">Order</button></div>
												<div class="clear"></div>												
											</div> <!-- pPurchase -->											
										</div> <!-- pInfo -->
										<div class="clear"></div> <!-- tttest -->
									</div>
									
									<div class="pBody">
										<div class="pTab">
											<ul>
												<li id="firstTab"><a href="#pAd">상품상세</a></li>
												<li><a href="#pReview">상품평</a></li>
												<li><a href="#pQA">상품문의</a></li>
												<li id="lastTab"><a href="#pEct">배송/교환/반품안내</a></li>																																				
											</ul>
										</div>
										<div class="pAd" id="pAd">
											<div class="pDetail">
												<div class="pDetail-Text">
													<p>설명</p>
													<ul>
														<li>디테일 1</li>
														<li>디테일 2</li>
														<li>디테일 3</li>	
													</ul>
												</div> <!-- pDetail-Text -->
												<div class="pDetail-ImageList">
													<div class="pDetail-Image">
														<c:forEach var="imgList" items="${list.proInfoList}" >
															<img src="img/${imgList}.png">
														</c:forEach>
													</div>																									
												</div> <!-- pDetail-ImageList-->
												<div class="pDetail-more">
													<button type="button" onclick="seeMore()" id="pDetail-Button">더보기</button>
												</div>
											</div>
										</div>
									</div> <!-- pBody -->
									
									<div class="pReview" id="pReview">
										<h4>상품평</h4>
										<p>동일한 상품에 대해 작성된 상품평으로, 판매자는 다를 수 있습니다.</p>
										
										<div class="rvBox">
											<div class="rvBox-title">
											
												<div class="rvBox-sort">
													<button id="bestBtn" onclick="setLineUp(this)">베스트순</button>
													<span> | </span>
													<button id="dayBtn" onclick="setLineUp(this)">최신순</button>
												</div>
												
												<div class="rvBox-searchBox">
													<div class="rvBox-searchBox-search">
														<div class="rvBox-searchBox-search-options">
															<div class="rvBox-searchBox-search-options-Btn" id="searchBtn"
																 onclick="dropdown(this)">
																<span id="search-option-select" >검색 옵션</span>
																<span id="search-options-icon" class="Material-Icons">arrow_drop_down</span>
															</div>
															<div class="rvBox-searchBox-search-options-list">
																<div id="search-options-writer" class="ops">
																	<input type="hidden" value="" />
																	<span class="test">검색옵션</span>
																</div>
																<div id="search-options-writer" class="ops">
																	<input type="hidden" value="W" />
																	<span class="test">작성자</span>
																</div>
																<div id="search-options-title" class="ops">
																	<input type="hidden" value="T">
																	<span>제목</span>
																</div>
																<div id="search-options-content" class="ops">
																	<input type="hidden" value="C">
																	<span>내용</span>
																</div>
															</div>
														</div>
														<div class="rvBox-searchBox-search-textBox">
															<input id="searchText" type="text">
															<span id="search_icon" class="Material-Icons" onclick="getKeyword()">search</span>
														</div>
													</div>
													
													<div class="rvBox-searchBox-stars">
														<div class="rvBox-searchBox-stars-Btn" id="starsBtn" onclick="dropdown(this)">
															<span id="stars-Btn" class="stars">★★★★★</span>
															<span class="Material-Icons">arrow_drop_down</span>
														</div>
														<div class="rvBox-searchBox-stars-list">
															<span class="ops stars">
																<input type="hidden" value="">
																<span>전체별점</span>
															</span>
															<span class="ops stars">
																<input type="hidden" value="5">
																<span>★★★★★</span>
															</span>
															<span class="ops stars">
																<input type="hidden" value="4">
																<span>★★★★</span>
															</span>
															<span class="ops stars">
																<input type="hidden" value="3">
																<span>★★★</span>
															</span>
															<span class="ops stars">
																<input type="hidden" value="2">
																<span>★★</span>
															</span>
															<span class="ops stars">
																<input type="hidden" value="1">
																<span>★</span>
															</span>
														</div>
													</div>
												</div>
											</div>
											
											<div class="rvBox-list" id="rvBox-list">
											</div> <!-- rvBox-list -->
											<div class="paging-container">
												<div class="paging" id="RVpaging">
												</div>
											</div>
										</div> <!-- rvBox -->
										
									</div> <!-- pReview -->
									
									<div class="pQA" id="pQA">
										<div class="qaBox">
											<div class="qaBox-title">
												<h4>상품문의</h4>
												<a href="<c:url value="/QAmyDetailPage/write?pro_title=${list.pro_title}"/>">문의하기</a>
												<div class="qaBox-notice">
													<ul>
														<li>- 상품문의 및 후기게시판을 통해 취소나 환불, 반품 등은 처리되지 않습니다.</li>
														<li>- 상품과 관계없는 글, 양도, 광고성, 욕설, 비방, 도배 등의 글은 예고 없이 이동, 노출제한, 삭제 등의 조치가 취해질 수 있습니다.</li>
														<li>- 공개 게시판이므로 전화번호, 메일 주소 등 고객님의 소중한 개인정보는 절대 남기지 말아주세요.</li>
													</ul>
												</div>
											</div> <!-- qaBox-title -->
												
											<div class="qaBox-list" id="qaBox-list">
											</div>
											<div class="paging-container">
												<div class="paging" id="QApaging">
												</div> <!-- paging -->
											</div> <!-- proBottom -->
										</div>
									</div> <!-- pQA -->
									
									<div class="pEct" id="pEct">
										<div class="EctBox">
											<h4>배송정보</h4>
											<table>
												<colgroup>
													<col width="100px">
													<col width="200px">
													<col width="80px">
												</colgroup>
												<tbody>
													<tr>
														<th>배송방법</th>
														<td>
															<ul>
																<li>순차배송</li>
															</ul>
														</td>
														<th rowspan="2">배송비</th>
														<td rowspan="2">
															<ul>
																<li>무료배송</li>
																<li>19,800원 이상 구매 시 무료배송</li>
																<li>도서산간 지역 추가비용 없음</li>
															</ul>
														</td>
													</tr>
													<tr>
														<th>묶음배송 여부</th>
														<td>
															<ul>
																<li>가능</li>
															</ul>
														</td>
													</tr>
													<tr>
														<th>배송기간</th>
														<td colspan="3">
															<ul>
																<li>주문 및 결제 완료 후, 2-3일 이내 도착</li>
																<li>도서 산간 지역 등은 하루가 더 소요될 수 있습니다.</li>
																<li>천재지변, 물량 수급 변동 등 예외적인 사유 발생 시, 다소 지연될 수 있는 점 양해 부탁드립니다.</li>
															</ul>
														</td>
													</tr>
												</tbody>
											</table>
											
											<h4>교환/반품 안내</h4>
											<ul>
												<li>ㆍ교환/반품에 관한 일반적인 사항은 판매자가 제시사항보다 관계법령이 우선합니다.</li>
												<li>ㆍ다만, 판매자의 제시사항이 관계법령보다 소비자에게 유리한 경우에는 판매자 제시사항이 적용됩니다.</li>
											</ul>
											<table>
												<colgroup>
													<col width="200px">
													<col width="*">
												</colgroup>
												<tr>
													<th>교환/반품 비용</th>
													<td>
														<ul>
															<li>1) [총 주문금액] - [반품 상품금액] = 19,800원 미만인 경우 반품비 5,000원</li>
															<li>2) [총 주문금액] - [반품 상품금액] = 19,800원 이상인 경우 반품비 2,500원</li>
														</ul>
													</td>
												</tr>
												<tr>
													<th>교환/반품 신청 기준일</th>
													<td>
														<ul>
															<li>ㆍ단순변심에 의한 상품의 교환/반품은 제품 수령 후 30일 이내까지, 교환/반품 제한사항에 해당하지 않는 경우에만 가능 (교환/반품 비용 고객부담)</li>
															<li>ㆍ상품의 내용이 표시·광고의 내용과 다른 경우에는 상품을 수령한 날부터 3개월 이내, 그 사실을 안 날 또는 알 수 있었던 날부터 30일 이내에 청약철회 가능</li>
														</ul>
													</td>
												</tr>
											</table>
											
											<h4>교환/반품 제한사항</h4>
											<ul>
												<li>ㆍ주문/제작 상품의 경우, 상품의 제작이 이미 진행된 경우</li>
												<li>ㆍ상품 포장을 개봉하여 사용 또는 설치 완료되어 상품의 가치가 훼손된 경우 (단, 내용 확인을 위한 포장 개봉의 경우는 예외)</li>
												<li>ㆍ고객의 사용, 시간경과, 일부 소비에 의하여 상품의 가치가 현저히 감소한 경우</li>
												<li>ㆍ세트상품 일부 사용, 구성품을 분실하였거나 취급 부주의로 인한 파손/고장/오염으로 재판매 불가한 경우</li>
												<li>ㆍ모니터 해상도의 차이로 인해 색상이나 이미지가 실제와 달라, 고객이 단순 변심으로 교환/반품을 무료로 요청하는 경우</li>
												<li>ㆍ제조사의 사정 (신모델 출시 등) 및 부품 가격 변동 등에 의해 무료 교환/반품으로 요청하는 경우</li>
											</ul>											
											<table>
												<colgroup>
													<col width="170px">
													<col width="*">
												</colgroup>
												<tr>
													<th>의류/잡화/수입명품</th>
													<td>
														<ul>
															<li>ㆍ상품의 택(TAG) 제거, 라벨 및 상품 훼손, 구성품 누락으로 상품의 가치가 현저히 감소된 경우</li>
														</ul>
													</td>
												</tr>
												<tr>
													<th>계절상품/식품/화장품</th>
													<td>
														<ul>
															<li>ㆍ신선/냉장/냉동 식품의 단순변심의 경우</li>
															<li>ㆍ뷰티 상품 이용 시 트러블(알러지, 붉은 반점, 가려움, 따가움)이 발생하는 경우, 진료 확인서 및 소견서 등을 증빙하면 환불이 가능 (제반비용 고객부담)</li>
														</ul>
													</td>
												</tr>
												<tr>
													<th>전자/가전/설치상품</th>
													<td>
														<ul>
															<li>ㆍ설치 또는 사용하여 재판매가 어려운 경우, 액정이 있는 상품의 전원을 켠 경우</li>
															<li>ㆍ상품의 시리얼 넘버 유출로 내장된 소프트웨어의 가치가 감소한 경우 (내비게이션, OS시리얼이 적힌 PMP)</li>
															<li>ㆍ홀로그램 등을 분리, 분실, 훼손하여 상품의 가치가 현저히 감소하여 재판매가 불가할 경우 (노트북, 데스크탑 PC 등)</li>
														</ul>
													</td>
												</tr>
											</table>
										</div>
									</div> <!-- pEct -->
									
								</div> <!-- proPage -->
	                    	</div> <!-- proUp -->
                    	</div> <!-- proCont -->
  
                    	<div id="proFoot"></div>

                    </div>
				</div>
			</div>
        </div> <!-- contents -->

<%@include file="include/footer.jsp"%>
</body>
</html>