import React, {useEffect, useState} from "react";
import axios from 'axios'
import {Modal, notification, Table} from 'antd'
import {ExclamationCircleOutlined} from "@ant-design/icons";

const {confirm} = Modal;


const columnsPersonnel = [
    {
        title: 'Adı',
        dataIndex: 'firstName',
        key: 'firstName',
    },
    {
        title: 'Soyadı',
        dataIndex: 'lastName',
        key: 'lastName',
    },
    {
        title: 'TC Kimlik No',
        dataIndex: 'identityNumber',
        key: 'identityNumber',
    },
    {
        title: 'Dogum Yeri',
        dataIndex: 'birthPlace',
        key: 'birthPlace',
    },
    {
        title: 'TC Kimlik No',
        dataIndex: 'identityNumber',
        key: 'identityNumber',
    },
    {
        title: 'Cinsiyet',
        dataIndex: 'gender',
        key: 'gender',
        render: gender => <p>{gender === 'MALE' ? 'Erkek' : gender === 'FEMALE' ? 'Kadın' : 'Belirtilmemiş'}</p>,

    },
    {
        title: 'Medeni Durum',
        dataIndex: 'maritalStatus',
        key: 'maritalStatus',
        render: maritalStatus =>
            <p>{maritalStatus === 'MARRIED' ? 'Evli' : maritalStatus === 'SINGLE' ? 'Bekar' : 'Boşanmış'}</p>,
    },
    {
        title: 'Email',
        dataIndex: 'email',
        key: 'email',
    },
    {
        title: 'Sürücü Belgesi',
        dataIndex: 'driverLicence',
        key: 'driverLicence',
    },
    {
        title: 'Kan Grubu',
        dataIndex: 'bloodGroup',
        key: 'bloodGroup',
    }, {
        title: 'Çalıştığı Bölüm',
        dataIndex: 'department.departmentName',
        key: 'departmentName',
    },
    {
        title: 'Adres Detay',
        dataIndex: 'adressDetail',
        key: 'adressDetail',
    }
];
const columnsAddress = [
    {
        title: 'Ülke',
        dataIndex: 'country',
        key: 'country',
    },
    {
        title: 'Şehir',
        dataIndex: 'city',
        key: 'city',
    },
    {
        title: 'Mahalle',
        dataIndex: 'district',
        key: 'district',
    }, {
        title: 'Cadde/Sokak',
        dataIndex: 'street',
        key: 'street',
    }, {
        title: 'Kapı Numarası',
        dataIndex: 'doorNo',
        key: 'doorNo',
    },
    {
        title: 'Adres Detayı',
        dataIndex: 'adressDetail',
        key: 'adressDetail',

    },
    {
        title: 'Adres Tipi',
        dataIndex: 'addressType',
        key: 'addressType',
        render: adressType => <p>{adressType === 'HOME' ? 'Ev' : adressType === 'BUSINESS' ? 'İşyeri' : 'Diğer'}</p>,

    }
];
const PersonnelList = () => {
    const [personels, setPersonels] = useState([]);
    const [isDeleted, setDeleted] = useState(false);
    const [isVisibleAddress, setVisibleAddress] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            const personelList = await axios.get("http://localhost:8099/api/personnel/all");
            console.log(personelList);
            return personelList;
        };
        fetchData().then(r => {
            setPersonels(r.data);
        }).catch(reason => {
            notification.error("Hata Oluştu", reason.data)
            console.log(reason.data)
        })
    }, [])

    const handleOk = () => {
        setVisibleAddress(false);
    }
    const handleCancel = () => {
        setVisibleAddress(false);
    }

    const openAddresDetailModel = () => {
        setVisibleAddress(true);
    }

    const deleteModalConfirm = (id, firstName, lastName, e) => {
        const personelName = firstName + ' ' + lastName;
        confirm({
            title: 'Silmek İstediginizden Emin misiniz?',
            icon: <ExclamationCircleOutlined/>,
            content: `${personelName} kişisini Silmek İstediginizden Emin misiniz?`

            ,
            okText: 'Evet',
            okType: 'danger',
            cancelText: 'Hayır',
            visible: true,
            onOk() {
                setDeleted(true)
                deletePersonnel(id, e)
            },
            onCancel() {
                setDeleted(false)
            },
        });
    }
    const deletePersonnel = async (id, e) => {
        debugger;
        if (isDeleted) {
            await axios.delete(
                `http://localhost:8099/api/personnel/delete/${id}`)
                .then(r => {
                    notification.success("Silme işlemi başarılı şekilde yapıldı")
                    console.log("personel silindi")
                }).catch(reason => {
                    notification.error("Hata Oluştu", reason.data)
                    console.log(reason.data)
                });
        }
    }

    // const getDataSource = () => {
//     debugger;
//     const dataSource =
//         personels ?
//             personels.map(p => {
//                     return (
//                         {
//                             key: `${p.id}`,
//                             firstName: `${p.firstName}`,
//                             lastName: `${p.lastName}`,
//                             identityNumber: `${p.identityNumber}`,
//                             birthPlace: `${p.birthPlace}`,
//                             gender: `${p.gender === 'MALE' ? 'Erkek' : p.gender === 'FEMALE' ? 'Kadın' : 'Bilinmiyor'}`,
//                             maritalStatus: `${p.maritalStatus === 'MARRIED'
//                                 ? 'Evli' : p.gender === 'SINGLE' ? 'Bekar' : 'Boşanmış'}`,
//                             email: `${p.email}`,
//                             driverLicence: `${p.driverLicence}`,
//                             departmentName: `${p.department.departmentName}`,
//                             address: `${p.driverLicence}`,
//                         }
//                     )
//                 }
//             ) : []
//
//     return dataSource;
// };
    return (
        <React.Fragment>
            {/*//*/}
            {/*// <Fragment>*/}
            <Table
                columns={columnsPersonnel}
                dataSource={personels}
                bordered={true}
                size="large"
                pagination={false}
            />
            {/*// </Fragment>*/}
            {/*<table className="table table-stripped table-hover table-light">*/}
            {/*    <thead>*/}
            {/*    <tr>*/}
            {/*        <th>Adı</th>*/}
            {/*        <th>Soyadı</th>*/}
            {/*        <th>TC Kimlik No</th>*/}
            {/*        <th>Dogum Yeri</th>*/}
            {/*        <th>Cinsiyet</th>*/}
            {/*        <th>Medeni Durum</th>*/}
            {/*        <th>Mail</th>*/}
            {/*        <th>Sürücü Belgesi</th>*/}
            {/*        <th>Kan Grubu</th>*/}
            {/*        <th>Çalıştığı Bölüm</th>*/}
            {/*    </tr>*/}
            {/*    </thead>*/}
            {/*    <tbody>*/}
            {/*    {*/}
            {/*        personels ?*/}
            {/*            personels.map(p => {*/}
            {/*                return (*/}
            {/*                    <tr key={p.id}>*/}
            {/*                        <td>{p.firstName}</td>*/}
            {/*                        <td>{p.lastName}</td>*/}
            {/*                        <td>{p.identityNumber}</td>*/}
            {/*                        <td>{p.birthPlace}</td>*/}
            {/*                        <td>{p.gender === 'MALE' ? 'Erkek' : p.gender === 'FEMALE' ? 'Kadın' : 'Bilinmiyor'}</td>*/}
            {/*                        <td>{p.maritalStatus === 'MARRIED' ? 'Evli' : p.gender === 'SINGLE' ? 'Bekar' : 'Boşanmış'}</td>*/}
            {/*                        <td>{p.email}</td>*/}
            {/*                        <td>{p.driverLicence}</td>*/}
            {/*                        <td>{p.bloodGroup}</td>*/}
            {/*                        <td>{p.department.departmentName}</td>*/}
            {/*                        <td>*/}
            {/*                            <button className="btn btn-outline-info"*/}
            {/*                                    onClick={() => openAddresDetailModel()}>Adres Bilgisi*/}
            {/*                            </button>*/}
            {/*                        </td>*/}
            {/*                        <td>*/}
            {/*                            <button className="btn btn-info">Güncelle</button>*/}
            {/*                        </td>*/}
            {/*                        <td>*/}
            {/*                            <button className="btn btn-danger"*/}
            {/*                                    onClick={() => deleteModalConfirm(p.id, p.firstName, p.lastName)}>Sil*/}
            {/*                            </button>*/}
            {/*                        </td>*/}
            {/*                    </tr>)*/}
            {/*            }) : null*/}
            {/*    }*/}
            {/*    </tbody>*/}
            {/*</table>*/}
            <Modal
                visible={isVisibleAddress}
                title="Address Detayı"
                onOk={handleOk}
                onCancel={handleCancel}
                width={1000}
            >
                <Table
                    columns={columnsAddress}
                    dataSource={personels[0] ? personels[0]?.address : null}
                />

            </Modal>
        </React.Fragment>
    )
}

export default PersonnelList;