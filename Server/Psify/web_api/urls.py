from django.conf.urls import url
from django.urls import path, include 
from web_api.views import UserListView, DoctorCreateView, DoctorLoginView
#from rest_framework import routers


#router = routers.DefaultRouter()
#router.register('moods', views.MoodListCreateView)	# unused on prod

urlpatterns = [
	#path('', include(router.urls))
	url(r'^patients/$', UserListView.as_view(), name='patients'),
	url(r'^doctor-create/$', DoctorCreateView.as_view(), name='doctor-create'),
	url(r'^doctor-login/$', DoctorLoginView.as_view(), name='doctor-login'),
]
