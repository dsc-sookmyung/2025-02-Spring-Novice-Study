const deleteButton = document.getElementById('delete-btn');

if(deleteButton){
    deleteButton.addEventListener('click',event=>{
        let id=document.getElementById('article-id').value;
        fetch(`/api/articles/${id}`,{
            method: 'DELETE'
        })
            .then(()=>{
                alert('삭제가 완료되었습니다.');
                location.replace('/articles');
            });
    });

}

const modifyButton = document.getElementById('modify-btn');

if(modifyButton){

    //클릭 이벤트가 감지되면 수정 API 요청
    modifyButton.addEventListener('click',event=>{
        //?id=123 같은 URL 쿼리 스트링을 파싱한다
        //id에는 parms에서 123만 가져온다
        let params=new URLSearchParams(location.search);
        let id=params.get('id');

        fetch(`/api/articles/${id}`, { //서버의 엔드포인트로 요청 보냄
            method: 'PUT',
            headers: { //서버에 보내는 데이터 형식이 json이라고 알려주는 헤더
                "content-Type": "application/json",
            },
            body: JSON.stringify({ //전송할 데이터를 JSON 문자열로 변환
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
            //fetch가 성공적으로 네트워크에 요청을 마치면 실행
            //사용자에게 완료 알림을 줌 => 이전 페이지로 이동
            .then(()=>{
                alert('수정이 완료되었습니다.');
                location.replace(`/articles/${id}`);
            });
    });
}

//등록 기능
//id가 create-btn인 element
const createButton=document.getElementById("create-btn");

if(createButton){
    //클릭 이벤트가 감지되면 생성 API 요청
    createButton.addEventListener("click",(event)=>{
        fetch("/api/articles",{
            method: "POST",
            headers: {
                "Content-Type":"application/json",
            },
            body: JSON.stringify({
                title: document.getElementById("title").value,
                content: document.getElementById("content").value,
            }),

        }).then(()=>{
            alert("등록 완료되었습니다.");
            location.replace("/articles");
        });
    });
}

