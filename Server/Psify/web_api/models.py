from django.db import models

# Create your models here.
class Doctor(models.Model):
	id_doctor	= models.AutoField(primary_key=True) # pk
	name		= models.CharField(max_length=50)
	surname		= models.CharField(max_length=50)
	email		= models.CharField(max_length=50)
	password	= models.CharField(max_length=12)
	phone		= models.IntegerField()
	adress		= models.CharField(max_length=100)
	certify		= models.CharField(max_length=100)
	profession	= models.CharField(max_length=50)
	#hours		