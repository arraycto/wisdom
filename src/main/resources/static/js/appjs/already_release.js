$(function(){
	alreadyReleaseCourse();
})

//搜索课程
function alreadyReleaseCourse(){
	$.ajax({
		url: "/toAlreadyReleasedCourse",
		type: "POST",
    	async: false,
    	success: function(data) {
    		$.each(data, function(n, value) {
    			var courseSearch = "<div class='course-item'>"+
    							       "<a href='/toCourseVideo?id="+value.id+"' target='_blank' class='course-detail-title'>"+
    							       	   "<img src='"+value.courseImg+"'>"+
    							       "</a>"+
    							       "<div class='course-item-detail'>"+
    							       	   "<a href='/toCourseVideo?id="+value.id+"' target='_blank' class='course-detail-title'>"+value.courseTitle+
    							       	   "</a>"+
    							       	   "<div class='course-item-classify'>"+
    							       	       "<span>"+value.courseAuthor+"</span>"+
    							       	       "<span>"+value.uploadTime+"</span>"+
    							       	   "</div>"+
    							       	   "<p>"+value.courseIntroduction+"</p>"+
    							       "</div>"+
    							   "</div>"
    			$("#search-content").append(courseSearch);
    		});
		}
	})
}