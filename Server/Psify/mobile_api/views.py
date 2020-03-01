from django.shortcuts import render
from rest_framework import viewsets, generics, views
from rest_framework.response import Response
from rest_framework import status
from .models import Mood, Event, User
from .serializers import MoodSerializer, EventSerializer, UserSerializer


class MoodListCreateView(generics.ListCreateAPIView):
    queryset = Mood.objects.all()
    serializer_class = MoodSerializer

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
		print(serializer.data)
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

