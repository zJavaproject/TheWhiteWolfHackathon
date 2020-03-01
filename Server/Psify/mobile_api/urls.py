from django.urls import path, include 
from .views import MoodListCreateView, UserCreateView
#from rest_framework import routers
from django.conf.urls import url

#router = routers.DefaultRouter()
#router.register('moods', views.MoodListCreateView)	# unused on prod

urlpatterns = [
	#path('', include(router.urls))
	url(r'^moods/$', MoodListCreateView.as_view(), name='moods'),
	url(r'^user-create/$', UserCreateView.as_view(), name='user-create')
	
]
