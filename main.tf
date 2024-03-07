provider "aws" {
  access_key = "AKIA5SCPHP3SKJLZLDPO"
  secret_key = "72jTnOek7lOKXGM1bgyRCsDyCWXQAZSW5LGBzvc/"
  region = "us-east-1"
}
resource "aws_instance" "example" {
    ami = "ami-0c7217cdde317cfec"
    instance_type = "t2.micro"
  
}