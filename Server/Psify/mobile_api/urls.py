from django.urls import path, include 
from django.conf.urls import url
from .views import MoodListCreateView, UserCreateView, UserSetDoctorView, UserLoginView, UserSetNotesView, UserSetDiagnosisView
#from rest_framework import routers

#router = routers.DefaultRouter()
#router.register('moods', views.MoodListCreateView)	# unused on prod

urlpatterns = [
	#path('', include(router.urls))
	url(r'^moods/$', MoodListCreateView.as_view(), name='moods'),
	url(r'^user-create/$', UserCreateView.as_view(), name='user-create'),
	url(r'^user-login$', UserLoginView.as_view(), name='login-doctor'),
	url(r'^user-update/$', UserSetDoctorView.as_view(), name='user-update'),
	url(r'^user-notes/$', UserSetNotesView.as_view(), name='user-notes'),
	url(r'^user-notes/$', UserSetDiagnosisView.as_view(), name='user-diagnosis')
]
