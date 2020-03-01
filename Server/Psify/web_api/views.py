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


# class DoctorRetrieveView(generics.RetrieveAPIView):
# 	serializer_class = DoctorSerializer

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

	# def retrieve(self, request, *args, **kwargs):
 #    instance = self.get_object() # here the object is retrieved
 #    serializer = self.get_serializer(instance)
 #    return Response(serializer.data)


	# def create(self, request, *args, **kwargs):
	# 	serializer = self.get_serializer(data=request.data)
	# 	serializer.is_valid(raise_exception=True)
	# 	headers = self.get_success_headers(serializer.data)

	# 	doctor, created = Doctor.objects.get_or_create(
	# 		login = request.data['email'],

	# 	)
	# 	user.login =  request.data['login']	# updates if changed
	# 	user.save()

	# 	token, created = Token.objects.update_or_create(
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

	# 	print("User-token data: ",serializer.data)

	# 	return Response(serializer.data, status=status.HTTP_201_CREATED, headers=headers)