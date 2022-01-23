# 온라인마트 통합관리 시스템 구현

![banner3](https://user-images.githubusercontent.com/95206325/150682758-c4979426-b42c-4254-ad26-501e6870a0f6.JPG)
<br>
<br>
<br>
<br>
자바콘솔 팀 프로젝트로 온라인 마트 통합관리 시스템을 구현해봤습니다.

**온라인 상거래 및 쇼핑의 증가**와 더불어 기존의 **오프라인 지출의 감소** 에 주목하여 <br>
기존 오프라인 판매 위주였던 마트의 온라인 시장 진출을 목표로 하였습니다.


<img  src="https://user-images.githubusercontent.com/95206325/150680827-03186cb1-b4a1-471a-9536-12bce13be975.jpg"  width="400"  height="200" >


 처음 해보는 개발 프로젝트로  많은 시행착오가 있었습니다.

그 중 가장 어려웠던 것은 **개발에 대한 지식이 부족**하여 기능상으로는 가능했지만 실제로 구현하는 것이 어려웠습니다.
 여러 차례 회의를 거치고  **협업**을 통해 조언을 얻고 매일 정기회의를 통해
 **진행상황 공유** 와  **상황에 따른 수정과 변동**을 결정하였습니다.
 
- **역할**
> 기획, 설계, 소스코드 작성에 대한 전반적인 참여
> 화면설계 ppt 템플릿 제작, 발표 ppt 제작

- **기획**
	> 분담하여 하는 팀프로젝트 특성상 수 차례 회의를 하고 결정하여도 기획에 대한 이해도는 개인별로 차이가 있을 수 있습니다. 
	> 이를 대비하여 구현목표는 자세히 쓰려 노력했습니다.
	
	![image](https://user-images.githubusercontent.com/95206325/150681257-5debce97-4e72-476f-af06-108fab5ac6ca.png)

	
	


-   **요구분석** 
	>  기존 기획서를 바탕으로 하되 기능별로 상세히 작동 방식을 설명하려 하였습니다.

![image](https://user-images.githubusercontent.com/95206325/150681417-8a8d9ba6-26b2-40e2-977a-4a987d07b2ce.png)

## 기능설계
![순서도](https://user-images.githubusercontent.com/95206325/150681881-727c9360-6da7-4907-b5bc-30134faed1bd.jpg)



## 화면설계

화면설계는 **java 콘솔창**과 동일하게 창을 만들어 어떤 방식으로 **출력**될지, 발표 때는 어떤 방식으로 화면을 세팅할지 미리 **결정**해두고 작업을 진행하였습니다. 

<img  src="https://user-images.githubusercontent.com/95206325/150681537-7613bc7e-b5be-4bbe-8634-ad98e478caf8.png"  width="400"  height="600" >


<img  src="https://user-images.githubusercontent.com/95206325/150681610-669921f1-3b7a-493c-a814-cce013f80c89.png"  width="400"  height="600" >

* 사용한 아스키코드의 출처를 표기하여 팀원들간의 소통을 원활하게 하였습니다.


## DETAILS

 **비회원**
 >1. 계정 찾기 : 이름과 전화번호를 통해 계정을 찾을 수 있다.  
>2. 회원 가입 : 몇가지 인적사항을 입력해 가입을 할 수 있다.  
>3. 로그인 : 회원가입을 통해 저장된 개인정보로 시스템에 접근한다.  
회원용/관리자용으로 나뉜다.

![image](https://user-images.githubusercontent.com/95206325/150682183-0c5ade7f-d84a-4a8e-8d42-69ba8e768175.png)
![image](https://user-images.githubusercontent.com/95206325/150682197-a4dd0c37-5cb1-47c6-8b64-9fba672a2e3f.png)
![image](https://user-images.githubusercontent.com/95206325/150682201-80fd6784-9071-479d-a767-637f57f5d99d.png)


 **회원**
 >  1. 상품 검색 : 초성이나 대체어로도 검색이 가능  
 > 2. 장바구니 담기 : 결제 전 장바구니 담기 기능 제공  
 > 3. 상품 결제 : 카드 / 현금 과 배송 옵션을 제공  
 > 4. 결제 내역 조회 : 최근 구매한 내역과 지난 내역 제공  
 > 5. 개인 정보 조회 : 회원가입 / 수정 한 회원 정보 제공
 > 
![image](https://user-images.githubusercontent.com/95206325/150682278-9e0e18ea-cbeb-4324-9dd9-c8fc8ab2fb51.png)
![image](https://user-images.githubusercontent.com/95206325/150682282-7b58de61-61fb-4f4a-a873-ff2b6c13a0cf.png)
![image](https://user-images.githubusercontent.com/95206325/150682284-02b782c1-d770-47fe-91ae-488162e59d2c.png)
 
 **관리자**
 >1. 회원 정보 조회 : 회원가입 한 모든 회원의 정보 제공  
>2. 상품 관리 : 새로운 상품을 등록, 수정  
>3. 매출 관리 : 현금 매출과 카드 매출을 나누어 확인  
>4. 재고 관리 : 기존 물품의 수량 입고 시 수정
 
![image](https://user-images.githubusercontent.com/95206325/150682302-e55a4b79-2852-4b69-b12e-31e5d3050c65.png)
![image](https://user-images.githubusercontent.com/95206325/150682309-35426eb7-ed66-4819-bf90-7ee41f53b016.png)
![image](https://user-images.githubusercontent.com/95206325/150682316-9b343a5b-5092-4b26-b2f6-926f864a4e2d.png)


## 프로젝트를 마치고

기획에 앞서 **프로젝트의 의도**와 **사용기술에 대한 이해** 가 충분해야 원활하게 진행될 수 있다는 것을 알았다. 
또한,  기능도 중요하지만  **화면구성**도 매우 중요하다는 것을 다른 조의 발표를 보며 깨달았다.  콘솔프로젝트이다 보니 대부분 비슷한 기능이였고 차이는 크지 않았다.  그중 우리 조는 **키워드 검색기능**을 지원했었다.  
대부분의 웹사이트는 키워드 검색을 지원하고 있기 때문에 **익숙**한 만큼 **편리**해보여야 했는데 
**화면 출력**과 **화면 간의 이동**이 **카테고리 검색**을 이용했던 조가 더 단순하고 깔끔했다.  기능만큼 **화면 출력**, **화면간의 이동**도 중요하기 때문에 이후 프로젝트부터는 화면 출력과 발표에 좀 더 신경써서 진행하려 노력했다. 
