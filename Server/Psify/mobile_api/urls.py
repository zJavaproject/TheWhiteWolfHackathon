from django.urls import path, include 
from .views import MoodListCreateView, UserCreateView, UserSetDoctorView, UserLoginView
#from rest_framework import routers
from django.conf.urls import url

#router = routers.DefaultRouter()
#router.register('moods', views.MoodListCreateView)	# unused on prod

urlpatterns = [
	#path('', include(router.urls))
	url(r'^moods/$', MoodListCreateView.as_view(), name='moods'),
	url(r'^user-create/$', UserCreateView.as_view(), name='user-create'),
	url(r'^user-login$', UserLoginView.as_view(), name='login-doctor'),
	url(r'^user-update/$', UserSetDoctorView.as_view(), name='user-update')
	
]
