from django.shortcuts import render
from rest_framework import viewsets, generics, views
from rest_framework.response import Response
from rest_framework import status
from mobile_api.models import Mood, Event, User
from web_api.models import Doctor
from mobile_api.serializers import UserSerializer, MoodSerializer, EventSerializer
from web_api.serializers import DoctorSerializer


class UserListView(generics.ListAPIView):
    #queryset = User.objects.all()
    serializer_class = UserSerializer
    def get_queryset(self):
    	queryset = User.objects.all()
    	id_doctor = self.request.query_params.get('id_doctor', None)
    	if id_doctor is not None:
    		queryset = queryset.filter(id_doctor=id_doctor)
    	return queryset


class DoctorCreateView(generics.CreateAPIView):
	serializer_class = DoctorSerializer

	def create(self, request, *args, **kwargs):
		serializer = self.get_serializer(data=request.data)
		serializer.is_valid(raise_exception=True)
		self.perform_create(serializer)
		headers = self.get_success_headers(serializer.data)
		print(serializer.data)
		return Response(serializer.data, status=status.HTTP_201_CREATED, headers=headers)

class DoctorLoginView(views.APIView):
    def post(self, request, format=None):
        data = request.data

        email = data.get('email', None)
        password = data.get('password', None)

        queryset = Doctor.objects.all()
        queryset = queryset.filter(email=email,password=password)

        print("user:",email, password)
        print("queryset:",queryset)
        if queryset:	# if not empty
            return Response(status=status.HTTP_200_OK)
        else:
            return Response(status=status.HTTP_404_NOT_FOUND)
