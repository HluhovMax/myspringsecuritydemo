INSERT INTO role VALUES (
                         1, 'ROLE_ADMIN'
                        );

INSERT INTO role VALUES (
                          2, 'ROLE_MODERATOR'
                        );

INSERT INTO role VALUES (
                          3, 'ROLE_USER'
                        );

INSERT INTO user VALUES (1, 'max', '25d55ad283aa400af464c76d713c07ad');-- password: 12345678 --

INSERT INTO role_user VALUES (1, 1);