from django.shortcuts import render
from rest_framework import viewsets, generics, views
from rest_framework.response import Response
from rest_framework import status
from .models import Mood, Event, User
from .serializers import MoodSerializer, EventSerializer, UserSerializer


class MoodListCreateView(generics.ListCreateAPIView):
    #queryset = Mood.objects.all()
    serializer_class = MoodSerializer

    def get_queryset(self):
    	queryset = Mood.objects.all()
    	id_user = self.request.query_params.get('id_user', None)
    	if id_user is not None:
    		queryset = queryset.filter(id_user=id_user)
    	return queryset

class EventListCreateView(generics.ListCreateAPIView):
	queryset = Event.objects.all()
	serializer_class = EventSerializer

class UserCreateView(generics.CreateAPIView):
	#queryset = User.objects.all()
	serializer_class = UserSerializer

	def create(self, request, *args, **kwargs):
		serializer = self.get_serializer(data=request.data)
		serializer.is_valid(raise_exception=True)
		self.perform_create(serializer)
		headers = self.get_success_headers(serializer.data)
		print("response:",serializer.data)
		return Response(serializer.data, status=status.HTTP_201_CREATED, headers=headers)

class UserLoginView(views.APIView):
	serializer_class = UserSerializer

	def post(self, request, format=None):
		data = request.data
		email = data.get('email', None)
		password = data.get('password', None)

		queryset = User.objects.all()
		queryset = queryset.filter(email=email,password=password)

		print("user:",email, password)
		print("queryset:",queryset)
		if queryset:	# if not empty
			return Response(status=status.HTTP_200_OK)
		else:
			return Response(status=status.HTTP_404_NOT_FOUND)

class UserSetDoctorView(generics.RetrieveAPIView):
	serializer_class = UserSerializer

	def get_object(self):	
		id_user = self.request.query_params.get('id_user', None)
		id_doctor = self.request.query_params.get('id_doctor', None)
		print("id_doctor:",id_doctor)
		User.objects.filter(id_user = id_user).update(id_doctor=id_doctor)
		return User.objects.get(id_user=id_user)

class UserSetNotesView(generics.RetrieveAPIView):
	serializer_class = UserSerializer

	def get_object(self):	
		id_user = self.request.query_params.get('id_user', None)
		notes = self.request.query_params.get('notes', None)
		print("new notes:", notes)
		old_notes = User.objects.get(id_user = id_user).notes
		print(old_notes)
		if old_notes is None:
			notes = notes
		else: 
			notes = notes + old_notes
		User.objects.filter(id_user = id_user).update(notes=notes)
		return User.objects.get(id_user=id_user)

	
class UserSetDiagnosisView(generics.RetrieveAPIView):
	serializer_class = UserSerializer

	def get_object(self):	
		id_user = self.request.query_params.get('id_user', None)
		diagnosis = self.request.query_params.get('diagnosis', None)
		print("new diagnosis:", diagnosis)

		User.objects.filter(id_user = id_user).update(diagnosis=diagnosis)
		return User.objects.get(id_user=id_user)


class UserSetAchtungView(generics.RetrieveAPIView):
	serializer_class = UserSerializer

	def get_object(self):	
		id_user = self.request.query_params.get('id_user', None)
		achtung = self.request.query_params.get('achtung', None)
		print("achtung:", achtung)

		if achtung == 'true' or achtung == 'True':
			User.objects.filter(id_user = id_user).update(achtung=True)
		else:
			User.objects.filter(id_user = id_user).update(achtung=True) 
		return User.objects.get(id_user=id_user)

