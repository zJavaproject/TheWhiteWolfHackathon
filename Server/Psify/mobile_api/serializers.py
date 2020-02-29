from rest_framework import serializers
from .models import Mood, Event

class MoodSerializer(serializers.ModelSerializer):
	class Meta:
		model = Mood
		fields = ('id_user','time','comment','happy','sad','calm','excited','bored','nervous','tired','scared','angry')

class EventSerializer(serializers.ModelSerializer):
	class Meta:
		model = Event
		fields = ('id_user','time_start','time_end','questions','comment')
