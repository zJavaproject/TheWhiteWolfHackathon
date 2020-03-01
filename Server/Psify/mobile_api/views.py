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

	# def get_queryset(self):
	# 	queryset = User.objects.all()
	# 	id_doctor = self.request.query_params.get('id_doctor', None)
	# 	id_user = self.request.query_params.get('id_user', None)

	# 	User.objects.filter(id_user = id_user).update(id_doctor=id_doctor)
	# 	print("id_doctor:",id_doctor)

	# 	# user_cnt = User.objects.filter(id_user = id_user).update(id_doctor=id_doctor)

	# 	# if user_cnt == 1:
	# 	# 	user = User.objects.filter(id_user = id_user)
	# 	# 	print(user)
	# 	# 	user.id_doctor = id_doctor
	# 	# 	print(user)
	# 	# 	queryset = queryset.filter(id_user=id_user)
	# 	return queryset



	# if id_doctor is not None and id_user is not none:

	# 	User, created = User.objects.update_or_create(
	# 		id_user = request.data['id_user'],
	# 		defaults = { 
	# 					 'access_token': request.data['access_token'], 
	# 					 'token_type': request.data['token_type'],  
	# 					 'refresh_token': request.data['refresh_token'], 
	# 					 'expires_in': request.data['expires_in'], 
	# 					 'jti':  request.data['jti']
	# 			}

	# 		)
	# 	token.save()

	# 	queryset = queryset.filter(id_user=id_user)
	# return queryset



	# def patch(self, request, id_user):

	# 	user = self.get_object(id_user=id_user)
	# 	serializer = SearchSerializer(user, data=request.data, partial=True) 

	# 	print("patch:",serializer.data)
	# 	if serializer.is_valid():
	# 		serializer.save()
	# 		return Response(serializer.data, status=status.HTTP_201_CREATED) # status = 201
		
	# 	return Response(serializer.data, status=status.HTTP_400_BAD_REQUEST) # status = 400


# class DoctorRetrieveView(generics.RetrieveAPIView):
	# serializer_class = DoctorSerializer

# 	def retrieve(self, request, *args, **kwargs):
# 		self.object = self.get_object()
# 		serializer = self.get_serializer(self.object)
# 		print(serializer)
# 		return Response(serializer.data)


#     def get_queryset(self):
# 		queryset = Doctor.objects.all()
# 		id_doctor = self.request.query_params.get('id_doctor', None)
# 		if id_doctor is not None:
# 			queryset = queryset.filter(id_doctor=id_doctor)
# 		return queryset