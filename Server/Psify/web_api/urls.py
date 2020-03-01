from django.conf.urls import url
from django.urls import path, include 
from web_api.views import UserListView, DoctorCreateView, DoctorLoginView
#from rest_framework import routers


#router = routers.DefaultRouter()
#router.register('moods', views.MoodListCreateView)	# unused on prod

urlpatterns = [
	#path('', include(router.urls))
	url(r'^patients/$', UserListView.as_view(), name='patients'),
	url(r'^create-doctor$', DoctorCreateView.as_view(), name='create-doctor'),
	url(r'^login-doctor$', DoctorLoginView.as_view(), name='login-doctor'),
]
