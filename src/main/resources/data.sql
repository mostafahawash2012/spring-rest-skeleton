insert into cc_user(id, name, email) 
values 
('aa5d6b24-072c-441f-8dc8-75263da994f4', 'Moustafa', 'mostafa@gmail.com'), 
('5805b681-78b2-40be-a988-2aa4dc4e10e1','Ahmed', 'Ahmed@gmail.com');

insert into organization(id, name) 
values 
('5ab988d5-de55-4be2-8390-23c594a4692d', 'Org 1'), 
('8146c007-d9cf-49ea-8104-41a7688eabce','Org 2');


insert into account(id, login) 
values 
('27056027-bc46-4855-9977-67fbbde324e8', 'login1'), 
('1628a197-92dd-43de-9a95-55217320d146','login2');


insert into cc_user_accounts(user_id, accounts_id) 
values 
('aa5d6b24-072c-441f-8dc8-75263da994f4', '27056027-bc46-4855-9977-67fbbde324e8'), 
('5805b681-78b2-40be-a988-2aa4dc4e10e1','1628a197-92dd-43de-9a95-55217320d146');



insert into org_group(id, name, organization_id, user_id) 
values 
('cfdbc364-bd13-4527-a0d7-bf1f3b0af90b','group 1','5ab988d5-de55-4be2-8390-23c594a4692d','aa5d6b24-072c-441f-8dc8-75263da994f4'), 
('b9bdcceb-3a2d-49de-9fb7-24d4cc0bad67','group 2','8146c007-d9cf-49ea-8104-41a7688eabce','aa5d6b24-072c-441f-8dc8-75263da994f4');




