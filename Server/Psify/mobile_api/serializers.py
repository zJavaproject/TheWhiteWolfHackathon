from rest_framework import serializers
from .models import Mood, Event, User

class MoodSerializer(serializers.ModelSerializer):
	class Meta:
		model = Mood
		fields = ('id_user','time','comment','happy','sad','calm','excited','bored','nervous','tired','scared','angry')

class EventSerializer(serializers.ModelSerializer):
	class Meta:
		model = Event
		fields = ('id_user','time_start','time_end','questions','comment')

class UserSerializer(serializers.ModelSerializer):
	class Meta:
		model = User
		fields = ('id_user','id_doctor','name','surname','phone','email','password','notes','diagnosis','achtung')
